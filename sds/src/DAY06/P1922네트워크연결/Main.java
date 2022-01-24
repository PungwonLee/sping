package DAY06.P1922네트워크연결;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int unf[];

	public static void main(String[] args) throws IOException {
		FastReader rd = new FastReader();
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO 자동 생성된 메소드 스텁
				return Integer.compare(o1[2], o2[2]);
			}
		});
		N = rd.nextInt();
		M = rd.nextInt();
		unf = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			unf[i] = i;
		}
		for (int i = 0; i < M; i++) {
			pq.add(new int[] { rd.nextInt(), rd.nextInt(), rd.nextInt() });
		}
		int res = 0;
		while (!pq.isEmpty()) {
			int a[] = pq.poll();
			int u = find(a[0]);
			int v = find(a[1]);
			if (u != v) {
				union(u, v);
				res += a[2];
			}
		}
		System.out.println(res);

	}

	static int find(int a) {
		if (unf[a] == a)
			return a;
		else
			return unf[a] = find(unf[a]);
	}

	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x != y) {
			unf[x] = unf[y];
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
