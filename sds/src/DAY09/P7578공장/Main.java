package DAY09.P7578공장;

import java.util.*;

import java.io.*;

public class Main {
	static int N, S;
	static int A[], B[];
	static long tree[];
	static HashMap<Integer, Integer> hs = new HashMap<>();

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		A = new int[N + 1];
		B = new int[N + 1];

		for (S = 1; S < N; S *= 2)
			;
		tree = new long[S * 2];

		for (int i = 1; i <= N; i++) {
			A[i] = rd.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			hs.put(rd.nextInt(), i);
		}

		long res = 0;
		for (int i = 1; i <= N; i++) {
			res += sumDU(hs.get(A[i]), N);
			updateDU(hs.get(A[i]), 1);
		}
		
		System.out.println(res);

	}

	static void updateDU(int idx, int val) {
		int X=S-1+idx;
		tree[X]=val;
		X/=2;
		while(X>0) {
			tree[X]=tree[X*2]+tree[X*2+1];
			X/=2;
		}
	}

	static long sumDU(int left, int right) {
		int leftPos = S - 1 + left;
		int rightPos = S - 1 + right;
		long sum = 0;
		while (leftPos <= rightPos) {
			if (leftPos % 2 == 1) {
				sum += tree[leftPos++];
			}
			if (rightPos % 2 == 0) {
				sum += tree[rightPos--];
			}
			leftPos /= 2;
			rightPos /= 2;
		}
		return sum;
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