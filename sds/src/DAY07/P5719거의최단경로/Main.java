package DAY07.P5719거의최단경로;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, S, D;
	static ArrayList<Edge> list[];
	static ArrayList<Integer> route[];
	static boolean visit[][];
	static int dist[];
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		StringBuilder sb= new StringBuilder();
		while (true) {
			N = rd.nextInt();
			M = rd.nextInt();
			if (N == 0 && M == 0) {
				System.out.println(sb);
				return;
			}

			S = rd.nextInt();
			D = rd.nextInt();
			list = new ArrayList[N + 1];
			route = new ArrayList[N + 1];
			dist = new int[N + 1];
			visit = new boolean[N + 1][N + 1];
			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<Edge>();
				route[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				list[rd.nextInt()].add(new Edge(rd.nextInt(), rd.nextInt()));
			}
			Dij();
			
			DFS(D);
			
			Dij();
			if(dist[D]==INF) {
				sb.append(-1+"\n");
			}else {
				sb.append(dist[D]+"\n");
			}
			

		}
	}

	static void DFS(int v) {
		if (v == S) {
			return;
		}
		
		for (int i = 0; i < route[v].size(); i++) {
			int next = route[v].get(i);
			if(visit[next][v])continue;
			visit[next][v]=true;
			DFS(next);
		}
	}

	static void Dij() {
		Arrays.fill(dist, INF); // dist배열 INF 로 초기화
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.val, o2.val);
			}
		});
		pq.add(new Edge(S, 0));
		dist[S] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (dist[cur.v] < cur.val) {
				continue;
			}
			for (int i = 0; i < list[cur.v].size(); i++) {
				Edge next = list[cur.v].get(i);
				if (visit[cur.v][next.v])
					continue;
				
				if (dist[next.v] > dist[cur.v] + next.val) {
					route[next.v].clear();
					route[next.v].add(cur.v);
					
					dist[next.v] = dist[cur.v] + next.val;
					pq.add(new Edge(next.v, dist[next.v]));
					
				} else if (dist[next.v] == dist[cur.v] + next.val) { // 거리가 같은 최단경로도 있으므로 추가한다.
					route[next.v].add(cur.v);
				}

			}
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
