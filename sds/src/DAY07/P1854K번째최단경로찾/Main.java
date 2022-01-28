package DAY07.P1854K번째최단경로찾;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K;
	static ArrayList<Edge> list[];
	static PriorityQueue<Integer> dist[];

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		StringBuilder sb = new StringBuilder();
		N = rd.nextInt();
		M = rd.nextInt();
		K = rd.nextInt();
		list = new ArrayList[N + 1];
		dist = new PriorityQueue[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Edge>();
			dist[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
		}
		for (int i = 0; i < M; i++) {
			list[rd.nextInt()].add(new Edge(rd.nextInt(), rd.nextInt()));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.val, o2.val);
			}
		});
		pq.add(new Edge(1, 0));
		dist[1].add(0);
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (dist[cur.v].peek() < cur.val)
				continue;
			for (int i = 0; i < list[cur.v].size(); i++) {
				Edge next = list[cur.v].get(i);
				int nextDist = cur.val + next.val;
				if (dist[next.v].size() < K) {
					dist[next.v].add(nextDist);
					pq.add(new Edge(next.v, nextDist));
				} else if (dist[next.v].peek() > nextDist) {
					dist[next.v].poll();
					dist[next.v].add(nextDist);
					pq.add(new Edge(next.v, nextDist));
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (dist[i].size()<K  ) {
				sb.append("-1\n");
			} else {
				sb.append(dist[i].peek() + "\n");
			}
		}
		System.out.println(sb);
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
