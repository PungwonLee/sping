package DAY06.P1516게임개발;

import java.io.*;
import java.util.*;

public class Main {

	static int cost[];
	static int count[];
	static int costMin[];
	static int N;
	static ArrayList<Integer> arr[];

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		cost = new int[N + 1];
		costMin = new int[N + 1];
		count = new int[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N; i++) {
			String[] str = rd.nextLine().split(" ");
			for (int j = 1; j < str.length - 1; j++) {
				arr[Integer.parseInt(str[j])].add(i);
				count[i]++;
			}
			cost[i] = Integer.parseInt(str[0]);
		}

		Deque<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				q.add(i);
				costMin[i] = cost[i];
			}
		}

		while (!q.isEmpty()) {
			int x = q.poll();

			for (int i = 0; i < arr[x].size(); i++) {
				int y = arr[x].get(i);
				count[y]--;
				if (count[y] == 0) {
					q.add(y);
				}
				costMin[y] = Math.max(costMin[y], costMin[x] + cost[y]);
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(costMin[i]);
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
