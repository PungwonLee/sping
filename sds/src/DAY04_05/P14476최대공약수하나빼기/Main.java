package DAY04_05.P14476최대공약수하나빼기;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(rd.nextInt());
		}
		ArrayList<Integer> gcd1 = new ArrayList<>(); // 왼쪽
		ArrayList<Integer> gcd2 = new ArrayList<>(); // 오른쪽
		gcd1.add(list.get(0));
		gcd2.add(list.get(list.size() - 1));
		for (int i = 1; i < N; i++) {
			gcd1.add(GCD(gcd1.get(i - 1), list.get(i)));
			gcd2.add(GCD(gcd2.get(i - 1), list.get(N - i - 1)));
		}
		int min = Integer.MAX_VALUE;
		int minval = 0;
		int val;
		
		for (int i = 0; i < N; i++) {

			if (i == 0)
				val = gcd2.get(N - i - 2);
			else if (i == N - 1)
				val = gcd1.get(i - 1);
			else
				val = GCD(gcd1.get(i - 1), gcd2.get(N - i - 2));
			
			if (list.get(i) % val != 0) {
				if (min > list.get(i)) {
					min = list.get(i);
					minval = val;
				}
			}
		}
		if (minval == 0) {
			System.out.println(-1);
		} else {
			System.out.println(minval + " " + min);
		}

	}

	static int GCD(int a, int b) {
		while (b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO 자동 생성된 catch 블록
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
			return str;
		}

	}

}
