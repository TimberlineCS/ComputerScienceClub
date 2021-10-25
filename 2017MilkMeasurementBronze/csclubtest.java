import java.util.*;
import java.io.*;
public class csclubtest {
    static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
	
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(new FileWriter(problemName + ".out"));
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
	
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
	
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
	
	static Kattio io;
	static {
		try {
			io = new Kattio("measurement");
		} catch(IOException e) {}
	}
	public static void main(String[] args) {
        int n =io.nextInt(); //input a from the user
        boolean[] is_max = new boolean[3];
        is_max[0] = is_max[1] = is_max[2] = true;

        int[] vals = new int[3];
        vals[0] = vals[1] = vals[2] = 7;


        int[] edit_val = new int[101];
        int[] edit_who = new int[101];

        for (int i=0;i<n;i++) {
            int day = io.nextInt();
            String name = io.next();
            int delta = io.nextInt();

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
                    next_max[j] = true;
            }

            for (int j=0;j<3;j++)
                if (is_max[j]!=next_max[j]) {
                    num_changes++;
                    break;
                }

            for (int j=0;j<3;j++)
                is_max[j] = next_max[j];
        }

        io.println(num_changes);
        io.close();
	}
}