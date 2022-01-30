package DAY06.P11438LCA2;

import java.io.*;
import java.util.*;

public class Main {

	static int logN, N, Q;
	static int depth[], parent[][]; // parent 2차원 dp 배열
	static ArrayList<Integer> list[];

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		StringBuilder sb = new StringBuilder();
		N = rd.nextInt();
		for (int K = 1; K <= N; K *= 2)
			logN++;

		list = new ArrayList[N + 1];
		depth = new int[N + 1];
		parent = new int[logN + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
			depth[i] = -1;
		}
		for (int i = 1; i <= N - 1; i++) {
			int u = rd.nextInt();
			int v = rd.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		// 깊이 및 부모 트리 저장 시작 BFS 이용
		Deque<Integer> q = new LinkedList<>();
		q.add(1);
		depth[1] = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int i = 0; i < list[x].size(); i++) {
				int y = list[x].get(i);
				if (depth[y] != -1)
					continue;
				q.add(y);
				depth[y] = depth[x] + 1;
				parent[0][y] = x;
			}
		}
		// dp 배열 생성 log(N)
		for (int i = 1; i <= logN; i++) {
			for (int j = 1; j <= N; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
			}
		}
		//
		Q = rd.nextInt();
		while (Q-- != 0) {
			sb.append(LCA(rd.nextInt(), rd.nextInt()) + "\n");
		}
		System.out.println(sb);

	}

	static int LCA(int a, int b) {
		if (depth[a] < depth[b]) { // a가 깊은걸로 지정
			int tmp = a;
			a = b;
			b = tmp;
		}
		for (int i = 0; i <= logN; i++) { // 깊이를 같게 a를 b위치로 올린다.
			if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
				a = parent[i][a];
			}
		}
		if (a == b)
			return a; // 같은 높이인데 값이 같으면 같은 부모이므로 부모의 값 리턴;

		for (int i = logN; i >= 0; i--) {
			if (parent[i][a] != parent[i][b]) { // 같은 높이이므로 i를 --하면 트리위로 거슬러 올라가면서 부모를 찾게됨
				a = parent[i][a];
				b = parent[i][b];
			}
		}
		return parent[0][a];
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
