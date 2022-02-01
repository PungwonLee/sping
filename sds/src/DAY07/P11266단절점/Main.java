package DAY07.P11266단절점;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int flag[], visit[], SearchOrder[];
	static ArrayList<Integer> list[];

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		StringBuilder sb= new StringBuilder();
		N = rd.nextInt();
		M = rd.nextInt();
		list = new ArrayList[N + 1];
		flag = new int[N + 1];
		SearchOrder = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int u = rd.nextInt();
			int v = rd.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		visit = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (visit[i] == 0) {
				dfs(i, 1, i);
			}
		}
		int cnt=0;
		for (int i = 1; i <= N; i++) {
			if (flag[i] == 1) {
				cnt++;
				sb.append(i+" ");
			}
		}
		System.out.println(cnt);
		if(cnt>0) {
			System.out.println(sb);
		}
		

	}

	static int dfs(int v, int orderLevel, int rootV) {
		visit[v] = 1;
		SearchOrder[v] = orderLevel;
		int rnt=orderLevel;
		int child = 0;
		for (int i = 0; i < list[v].size(); i++) {
			int u = list[v].get(i);
			
			if (visit[u] != 0) {
				rnt = Math.min(SearchOrder[u], rnt);
			} else {
				child++;
				
				int low = dfs(u, orderLevel + 1, rootV);
			
				if (rootV != v && SearchOrder[v] <= low) {
					flag[v] = 1;
				}
				rnt = Math.min(rnt, low);

			}
		}

		if (rootV == v && child >= 2) {
			flag[v] = 1;
		}
		return rnt;
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
