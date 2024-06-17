import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[] cow;
    static Set<Integer> start = new HashSet<>();
    static  boolean[] passedTo;
    static int passed;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("hoofball.in"));
        PrintWriter pw = new PrintWriter("hoofball.out");
        n = sc.nextInt();
        cow = new int[n];
        for (int i = 0; i < n; i++) {
            cow[i] = sc.nextInt();
        }
        if (cow.length == 1) {
            pw.println(1);
            pw.close();
            System.exit(0);
        }
        Arrays.sort(cow);
        passedTo = new boolean[n];
        pw.println(run());
        pw.close();
    }
    static int run() {
        for (int i = 0; i < cow.length; i++) {
            if (passed==cow.length) {
                break;
            }
            if (!passedTo[i]) {
                pass(i);
            }
        }
        return start.size();
    }

    static void pass(int i) {
        start.add(i);
        passedTo[i] = true;
        int prev = -1;
        while (true) {
            if (!(i==passedTo.length-1)
            && (i==0||cow[i]-cow[i-1] > cow[i+1] - cow[i])) {
                i++;
                passedTo[i] = true;
                if (i == prev) {
                    break;
                }
                prev = i-1;
            } else {
                i--;
                passedTo[i] = true;
                if(i==prev) {
                    break;
                }
                prev = i+1;
            }
            if(start.contains(i))
            {
                start.remove(i);
                break;
            }
        }

    }
}