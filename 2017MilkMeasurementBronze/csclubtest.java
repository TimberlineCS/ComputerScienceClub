import java.util.*;
import java.io.*;
public class csclubtest {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
        int n = sc.nextInt(); //input a from the user
        boolean[] is_max = new boolean[3];
        is_max[0] = is_max[1] = is_max[2] = true;

        int[] vals = new int[3];
        vals[0] = vals[1] = vals[2] = 7;


        int[] edit_val = new int[101];
        int[] edit_who = new int[101];

        for (int i=0;i<n;i++) {
            int day = sc.nextInt();
            String name = sc.next();
            int delta = sc.nextInt();

            edit_val[day] = delta;
            if (name.equals("Bessie"))
                edit_who[day] = 0;
            if (name.equals("Elsie"))
                edit_who[day] = 1;
            if (name.equals("Mildred"))
                edit_who[day] = 2;
        }

        int num_changes = 0;
        for (int i=0;i<=100;i++) {
            vals[edit_who[i]] += edit_val[i]; //applies the update
            int max = Math.max(vals[0], Math.max(vals[1], vals[2]));

            boolean[] next_max = new boolean[3];
            for (int j=0;j<3;j++) {
                if (vals[j]==max)
                next_max[j] = true
            }
        }
	}
}