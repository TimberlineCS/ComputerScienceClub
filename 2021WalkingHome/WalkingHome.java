import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class WalkingHome {
    public static void main(String[] args) {
        int N, K;
        File f = new File("WalkingHome.txt");
        try (Scanner s = new Scanner(f)) {
            N = s.nextInt();
            K = s.nextInt();
            s.nextLine();
            boolean[][] blocked = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String str = s.nextLine();
                System.out.println(str.length());
                for (int j = 0; j < N; j++) {
                    blocked[i][j] = (str.charAt(j) == 'H');
                }
            }
            int total = 0;
            if (K >= 1) {
                // right, then down
                boolean worked = true;
                for (int i = 0; i < N; i++) {
                    if (blocked[0][i]) {
                        worked = false;
                        break;
                    }
                }
                for (int i = 0; i < N; i++) {
                    if (blocked[i][N - 1]) {
                        worked = false;
                        break;
                    }
                }
                if (worked) {
                    total++;
                }
                worked = true;
                for (int i = 0; i < N; i++) {
                    if (blocked[i][0]) {
                        worked = false;
                        break;
                    }
                }
                for (int i = 0; i < N; i++) {
                    if (blocked[N - 1][i]) {
                        worked = false;
                        break;
                    }
                }
                if (worked) {
                    total++;
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
