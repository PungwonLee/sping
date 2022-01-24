package DAY06.P1717집합의표현;

import java.io.*;
import java.util.*;

public class Main {
	static int unf[];
	static int N, M;

	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x != y) {
			unf[x] = y;
		}
	}

	static int find(int a) {

		if (unf[a] == a)
			return a;
		else
			return unf[a] = find(unf[a]);
	}

	public static void main(String[] args) throws IOException {
		FastReader rd = new FastReader();
		StringBuilder sb = new StringBuilder();
		N = rd.nextInt();
		M = rd.nextInt();

		unf = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			unf[i] = i;
		}
		int op, u, v;
		for (int i = 0; i < M; i++) {
			op = rd.nextInt();
			u = rd.nextInt();
			v = rd.nextInt();
			if (op == 0) {
				union(u, v);
			} else {
				if (find(u) != find(v)) {
					sb.append("NO\n");
				} else {
					sb.append("YES\n");
				}
			}
		}
		System.out.println(sb);
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
					// TODO 자동 생성된 catch 블록
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
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
			return str;
		}
	}

}
