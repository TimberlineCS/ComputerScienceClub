import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int N, Q;
    static String fence;
    static int start[] = new int[100000];
    static int end[] = new int[100000];
    static char maxActiveColor;

    static int[] get_prefix_sum(String str) {
        int[] res = new int[N];
        ArrayList<Character> activeColors = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                res[i] = 0;
            } else {
                res[i] = res[i - 1];
            }
            char c = str.charAt(i);
            for (int j = 0; j < activeColors.size(); j++) {
                if (activeColors.get(j) > c) {
                    activeColors.remove(j);
                    j--;
                }
            }
            if (activeColors.isEmpty() || maxActiveColor < c) {
                activeColors.add(c);
                maxActiveColor = c;
                res[i]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        Q = s.nextInt();
        fence = s.nextLine();
        for (int i = 0; i < Q; i++) {
            start[i] = s.nextInt();
            end[i] = s.nextInt();
        }
        
    }
}
