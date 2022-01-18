package DAY02.P2806나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    static boolean func(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] - mid > 0) {
                sum += (arr[i] - mid);
            }
        }
        if (M <= sum) return true;
        else return false;
    }

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        M = rd.nextInt();
        arr = new int[N];
        int r = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextInt();
            if (r < arr[i]) {
                r = arr[i];
            }
        }
        Arrays.sort(arr);
        int res = 0;
        int l = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (func(mid)) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
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
