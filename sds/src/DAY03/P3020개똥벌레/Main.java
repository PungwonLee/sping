package DAY03.P3020개똥벌레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        int H = rd.nextInt();
        int arr[] = new int[N / 2];
        int arr2[] = new int[N / 2];
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < N / 2; i++) {
            arr[i] = rd.nextInt();
            arr2[i] = H - rd.nextInt() + 1;
        }
        Arrays.sort(arr);
        Arrays.sort(arr2);
        for (int i = 1; i <= H; i++) {
            int l = 0, r = N / 2 - 1, sum = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (i > arr[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
//                System.out.println(l);
            if (l <= N / 2) {
                sum += (N / 2 - l);
            }
            l = 0;
            r = N / 2 - 1;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (i >= arr2[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (l <= N / 2) {
                sum += (l);
            }
            if (sum < min) {
                min = sum;
                cnt = 1;
            } else if (sum == min) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
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
