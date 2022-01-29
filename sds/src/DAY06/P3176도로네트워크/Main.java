package DAY06.P3176도로네트워크;

import java.util.*;

import java.io.*;

public class Main {
	static int N, K;
	static int logN;
	static ArrayList<Edge> list[];
	static int parent[][], depth[], parentMax[][], parentMin[][];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		list = new ArrayList[N + 1];
		depth = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Edge>();
		}
		for (int i = 1; i <= N; i *= 2)
			logN++;

		parent = new int[logN + 1][N + 1];
		parentMax = new int[logN + 1][N + 1];
		parentMin = new int[logN + 1][N + 1];

		for (int i = 0; i < N - 1; i++) {
			int u = rd.nextInt();
			int v = rd.nextInt();
			int val = rd.nextInt();
			list[u].add(new Edge(v, val));
			list[v].add(new Edge(u, val));
			min = Math.min(min, val);
			max = Math.max(max, val);
		}

		dfs(1, -1, 0);
		/*
		 * System.out.println(Arrays.toString(depth));
		 * System.out.println(Arrays.toString(parent[0]));
		 * System.out.println(Arrays.toString(parentMax[0]));
		 * System.out.println(Arrays.toString(parentMin[0]));
		 */
		for (int i = 1; i <= logN; i++) {

			for (int j = 1; j <= N; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
				parentMax[i][j] = Math.max(parentMax[i - 1][parent[i - 1][j]], parentMax[i - 1][j]);
				parentMin[i][j] = Math.min(parentMin[i - 1][parent[i - 1][j]], parentMin[i - 1][j]);
			}
		}

		K = rd.nextInt();
		while (K-- != 0) {
			LCA(rd.nextInt(), rd.nextInt());
		}

	}

	static void LCA(int a, int b) {

		if (depth[a] < depth[b]) { // a가 더 깊은걸로
			int tmp = a;
			a = b;
			b = tmp;
		}
		int Min = Integer.MAX_VALUE;
		int Max = Integer.MIN_VALUE;
		int i = 0;
		for (; i < logN; i++) {
			if ((depth[a] - depth[b] & (1 << i)) >= 1) {

				Min = Math.min(Min, parentMin[i][a]);
				Max = Math.max(Max, parentMax[i][a]);
				a = parent[i][a];

			}
		}

		if (a == b) {
			System.out.println(Min + " " + Max);
			return;
		}

		for (i = logN; i >= 0; i--) {
			if (parent[i][a] != parent[i][b]) {
				Min = Math.min(Min, parentMin[i][a]);
				Min = Math.min(Min, parentMin[i][b]);
				Max = Math.max(Max, parentMax[i][b]);
				Max = Math.max(Max, parentMax[i][a]);
				a = parent[i][a];
				b = parent[i][b];

			}
		}
		Min = Math.min(Min, parentMin[0][a]);
		Min = Math.min(Min, parentMin[0][b]);
		Max = Math.max(Max, parentMax[0][b]);
		Max = Math.max(Max, parentMax[0][a]);
		System.out.println(Min + " " + Max);
	}

	static void dfs(int now, int par, int v) {
		for (int i = 0; i < list[now].size(); i++) {
			Edge next = list[now].get(i);
			if (next.v == par)
				continue;
			depth[next.v] = depth[now] + 1;
			parent[0][next.v] = now;
			parentMax[0][next.v] = next.val;
			parentMin[0][next.v] = next.val;
			dfs(next.v, now, v + 1);

		}
	}

	static class Edge {
		int v;
		int val;

		public Edge(int v, int val) {
			this.v = v;
			this.val = val;

		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
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