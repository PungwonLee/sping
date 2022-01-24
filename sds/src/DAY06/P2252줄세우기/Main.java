package DAY06.P2252줄세우기;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> arr[];
	static int count[];
	static int N, M;
	static Deque<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		FastReader rd = new FastReader();
		StringBuilder sb = new StringBuilder();
		N = rd.nextInt();
		M = rd.nextInt();
		arr = new ArrayList[N + 1];
		count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		int u, v;
		for (int i = 0; i < M; i++) {
			u = rd.nextInt();
			v = rd.nextInt();
			arr[u].add(v);
			count[v]++;
		}
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int x = q.poll();
			sb.append(x+" ");
			for (int i = 0; i < arr[x].size(); i++) {
				int y = arr[x].get(i);
				count[y]--;
				if (count[y] == 0) {
					q.add(y);
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
