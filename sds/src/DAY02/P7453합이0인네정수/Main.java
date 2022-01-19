package DAY02.P7453합이0인네정수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N;
    static long res;
    static int[][] arr;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        arr = new int[4][N];
        for (int i = 0; i < N; i++) {
            String[] s = rd.nextLine().split(" ");

            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(s[j]);
            }
        }
        int AB[] = new int[N * N];
        int CD[] = new int[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {       //A와 B C와 D 미리 합치기 O(N^2)
                AB[idx] = arr[0][i] + arr[1][j];
                CD[idx++] = arr[2][i] + arr[3][j];
            }
        }
        Arrays.sort(CD);

        for (int i = 0; i < N * N; i++) {    //O(N^2 * logN^2) log1600만==약 24회 384,000,000
            int l = 0, r = N * N - 1, point = -1;
            while (l <= r) {
                int mid = (l + r) / 2;

                if (AB[i] + CD[mid] <= 0) {
                    l = mid + 1;

                } else {
                    r = mid - 1;
                }
            }
            point = l;
            l = 0;
            r = N * N - 1;
            while (l <= r) {
                int mid = (l + r) / 2;

                if (AB[i] + CD[mid] < 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            res += (point - l);
        }


        System.out.println(res);
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
