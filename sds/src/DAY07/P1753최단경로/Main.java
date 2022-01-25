package DAY07.P1753최단경로;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M, start;
	static ArrayList<Edge> list[];
	static int dist[];
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		StringBuilder sb = new StringBuilder();
		N = rd.nextInt();
		M = rd.nextInt();
		start = rd.nextInt();
		list = new ArrayList[N + 1];
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = INF;
		}
		for (int i = 0; i < M; i++) {
			list[rd.nextInt()].add(new Edge(rd.nextInt(), rd.nextInt()));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.val, o2.val);
			}
		});

		pq.add(new Edge(start, 0));
		dist[start] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (dist[cur.v] != cur.val)
				continue;
			for (int i = 0; i < list[cur.v].size(); i++) {
				Edge next = list[cur.v].get(i);
				if (dist[next.v] > dist[cur.v] + next.val) {
					dist[next.v] = dist[cur.v] + next.val;
					pq.add(new Edge(next.v,dist[next.v]));
				}
			}

		}
		for (int i = 1; i <= N; i++) {
			if (dist[i] == INF)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");
		}

		System.out.println(sb);
	}

	static class Edge {
		int v, val;

		public Edge(int v, int val) {

			this.v = v;
			this.val = val;

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
