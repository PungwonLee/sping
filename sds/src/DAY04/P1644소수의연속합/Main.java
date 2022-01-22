package DAY04.P1644소수의연속합;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		boolean isNotPrime[] = new boolean[N + 1];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if (!isNotPrime[i]) {
				primeList.add(i);
				for (int j = i + i; j <= N; j += i) {
					if (!isNotPrime[j]) {
						isNotPrime[j] = true;
					}
				}
			}
		}
		int l = 0, r = 0, sum = 0, cnt = 0;

		while (l < primeList.size() && r < primeList.size()) {
			while (r < primeList.size() && sum < N) {
				sum += primeList.get(r++);
				if (sum == N)
					cnt++;
			}

			sum -= primeList.get(l++);
			if (sum == N)
				cnt++;
		}
		System.out.println(cnt);
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
					// TODO 자동 생성된 catch 블록
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
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
			return str;
		}
	}

}
