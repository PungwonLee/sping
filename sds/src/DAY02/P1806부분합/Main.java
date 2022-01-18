package DAY02.P1806부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        int M = rd.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextInt();
        }
        int p1 = 0, p2 = 0, min = N+1, len = 0, sum = 0;
        while (p1 < N) {
            while (p2 < N && sum < M) {
                sum += arr[p2++];
            }

            if (sum >= M) {
                min = Math.min(min, p2 - p1);
            }
            sum -= arr[p1++];
        }

        if (min != N+1) {
            System.out.println(min);
        }else{
            System.out.println(0);
        }
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
