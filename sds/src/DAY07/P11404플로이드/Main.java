package DAY07.P11404플로이드;

import java.io.*;
import java.util.*;

public class Main {

	static int arr[][];
	static int N, M;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		M = rd.nextInt();
		arr = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				arr[i][j] = INF;
				if (i == j)
					arr[i][j] = 0;
			}
		}
		int u, v, w;
		for (int i = 0; i < M; i++) {
			u = rd.nextInt();
			v = rd.nextInt();
			w = rd.nextInt();
			if (arr[u][v] > w) {
				arr[u][v] = w;
			}

		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j || arr[i][k] == INF || arr[k][j] == INF)
						continue;
					if (arr[i][j] > arr[k][j] + arr[i][k]) {
						arr[i][j] = arr[k][j] + arr[i][k];
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(arr[i][j]==INF)arr[i][j]=0;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
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
