package DAY09.P7579앱;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		int M = rd.nextInt();
		int cost[] = new int[N + 1];
		int m[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			m[i] = rd.nextInt();
		}
		int total = 0;
		for (int i = 1; i <= N; i++) {
			cost[i] = rd.nextInt();
			total += cost[i];
		}
		int DP[][] = new int[N + 1][total + 1];

		for (int i = 1; i <= N; i++) {

			for (int j = 0; j <= total; j++) {
				DP[i][j] = DP[i - 1][j];
				if (j - cost[i] >= 0) {
					DP[i][j] = Math.max(DP[i - 1][j - cost[i]] + m[i], DP[i][j]);
				}
			}
			
		}
		for(int i=0;i<=total;i++) {
			if(DP[N][i]>=M) {
				System.out.println(i);
				break;
			}
		}

	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
