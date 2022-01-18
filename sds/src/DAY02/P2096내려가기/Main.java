package DAY02.P2096내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        int DP[][] = new int[2][3];
        int DP2[][] = new int[2][3];
        String[] input = rd.nextLine().split(" ");
        DP[0][0] = Integer.parseInt(input[0]);
        DP[0][1] = Integer.parseInt(input[1]);
        DP[0][2] = Integer.parseInt(input[2]);
        DP2[0][0] = Integer.parseInt(input[0]);
        DP2[0][1] = Integer.parseInt(input[1]);
        DP2[0][2] = Integer.parseInt(input[2]);
        for (int i = 0; i < N - 1; i++) {
            input = rd.nextLine().split(" ");

            DP[1][0] = Math.min(DP[0][0], DP[0][1]) + Integer.parseInt(input[0]);
            DP[1][1] = Math.min(DP[0][0], Math.min(DP[0][1], DP[0][2])) + Integer.parseInt(input[1]);
            DP[1][2] = Math.min(DP[0][1], DP[0][2]) + Integer.parseInt(input[2]);

            DP2[1][0] = Math.max(DP2[0][0], DP2[0][1]) + Integer.parseInt(input[0]);
            DP2[1][1] = Math.max(DP2[0][0], Math.max(DP2[0][1], DP2[0][2])) + Integer.parseInt(input[1]);
            DP2[1][2] = Math.max(DP2[0][1], DP2[0][2]) + Integer.parseInt(input[2]);

            for (int j = 0; j < 3; j++) {
                DP[0][j] = DP[1][j];
                DP2[0][j] = DP2[1][j];
            }
        }
        System.out.println(Arrays.stream(DP2[0]).max().getAsInt() + " " + Arrays.stream(DP[0]).min().getAsInt());

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
