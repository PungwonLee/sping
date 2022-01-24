package DAY05.P5568카드놓기;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int arr[], select[], check[];
	static HashSet<String> hs = new HashSet<>();

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		M = rd.nextInt();
		arr = new int[N];
		select = new int[M];
		check = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = rd.nextInt();
		}
		func(0);
		System.out.println(hs.size());
	}

	static void func(int v) {
		if (v == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {

				sb.append(select[i]);
			}
			hs.add(sb.toString());
		} else if (v < M) {
			for (int i = 0; i < N; i++) {
				if (check[i] == 0) {
					check[i]=1;
					select[v] = arr[i];
					func(v + 1);
					select[v] = 0;
					check[i]=0;
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
