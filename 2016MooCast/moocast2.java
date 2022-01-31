
import java.io.*;
import java.util.*;

public class moocast2 {

    static boolean canReach(int x1, int y1, int x2, int y2, int r) {
        int lhs = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        int rhs = r*r;
        return lhs <= rhs;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] y = new int[N];
        int[] r = new int[N];
        for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
        boolean[][] canTransmit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            int ourR = r[i];
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (canReach(x[i], y[i], x[j], y[j])) {
                    
                }
            }
        }
    }
}
