package DAY04.P2960에라토스테네스의체;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		int K = rd.nextInt();
		boolean isNotPrime[] = new boolean[N + 1];
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (!isNotPrime[i]) {
				cnt++;
				if (cnt == K) {
					System.out.println(i);
					return;
				}
				for (int j = i + i; j <= N; j += i) {
					if (!isNotPrime[j]) {
						isNotPrime[j] = true;
						cnt++;
						if (cnt == K) {
							System.out.println(j);
							return;
						}
					}

				}
			}
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
