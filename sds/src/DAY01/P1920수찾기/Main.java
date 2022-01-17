package DAY01.P1920수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        long arr[] = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextLong();
        }
        int M = rd.nextInt();
        long arr2[] = new long[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = rd.nextLong();
        }

        Arrays.sort(arr);
        for (long arrVal : arr2) {
            int l = 0, r = N-1;
            boolean flag = false;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (arrVal == arr[mid]) {
                    flag = true;
                    break;
                } else if (arrVal < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (flag) System.out.println(1);
            else System.out.println(0);
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
