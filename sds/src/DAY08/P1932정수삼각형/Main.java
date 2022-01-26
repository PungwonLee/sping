package DAY08.P1932정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        int arr[][] = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = rd.nextInt();
                if (i != 0) {
                    if (j == 0) {
                        arr[i][j] += arr[i - 1][j];
                    } else if (j == i) {
                        arr[i][j] += arr[i - 1][j - 1];
                    } else {
                        arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
                    }
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.println(max);
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
