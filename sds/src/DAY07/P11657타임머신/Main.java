package DAY07.P11657타임머신;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int arr[][];
	static long dist[];
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		M = rd.nextInt();
		arr = new int[M][3];
		dist = new long[N + 1];

		for (int i = 0; i < M; i++) {
			arr[i][0] = rd.nextInt();
			arr[i][1] = rd.nextInt();
			arr[i][2] = rd.nextInt();
		}

		for (int i = 0; i <= N; i++) {
			dist[i] = INF;
		}
		dist[1] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				int u = arr[j][0];
				int v = arr[j][1];
				int w = arr[j][2];
				if (dist[u] != INF && dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					if(i==N) {
						System.out.println(-1);
						return;
					}
				}
				
			}
		}
		for(int i=2;i<=N;i++) {
			if(dist[i]==INF) {
				System.out.println("-1");
			}else {
				System.out.println(dist[i]);
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
