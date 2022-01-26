package DAY06.P3830교수님은기다리지않는다;

import java.io.*;
import java.util.*;

public class test {
	static int N, M;
	static int unf[];
	static long weight[];

	static int find(int a) {
		System.out.println("(find) a= " + a + " unf[a] = " + unf[a]);
		if (unf[a] == a)
			return a;
		else {
			System.out.println("=========else");
			int parentIndex = find(unf[a]);
			System.out.println("(else find) a= " + a + " unf[a] = " + unf[a]);
			System.out.println("parentIndex = " + parentIndex + " unf[a] = " + unf[a]);
			System.out.println("전 weight[a] = " + weight[a] + "  weight[unf[a]] = " + weight[unf[a]]);
			weight[a] += weight[unf[a]];
			System.out.println("후 weight[a] = " + weight[a] + "  weight[unf[a]] = " + weight[unf[a]]);
			return unf[a] = parentIndex;
		}
	}

	static void union(int a, int b, int diff) {
		System.out.println("==========union a= " + a);
		int x = find(a);
		System.out.println("==========union b= " + b);
		int y = find(b);

		if (x != y) {
			System.out.println("----------x!=y-------");
			System.out.println("x == " + x + " y== " + y);
			System.out.println("weighy= " + weight[y] + " " + weight[a] + " " + weight[b] + " " + diff);
			weight[y] = weight[a] - weight[b] + diff;
			System.out.println("weighy= " + weight[y] + " " + weight[a] + " " + weight[b] + " " + diff);
			unf[y] = unf[x];
			System.out.println("unf[y] ,x =" + unf[y] + " " + unf[x]);
		}

	}

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		while (true) {
			N = rd.nextInt();
			M = rd.nextInt();

			if (N == 0 && M == 0)
				break;

			weight = new long[N + 1];
			unf = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				unf[i] = i;
			}
			while (M-- != 0) {

				String op = rd.next();
				int a = rd.nextInt();
				int b = rd.nextInt();

				if (op.equals("!")) {

					int w = rd.nextInt();
					union(a, b, w);

				} else if(op.equals("?")) {
					System.out.println("==========!===========");
					System.out.println("=====a");
					int x = find(a);
					System.out.println("=====b");
					int y = find(b);
					if (x == y) {
						System.out.println(weight[b] - weight[a]);
					} else {
						System.out.println("UNKNOWN");
					}
				}else {
					System.out.println(Arrays.toString(unf));
					System.out.println(Arrays.toString(weight));
				}

			}
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
