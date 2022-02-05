package DAY02.P2143두배열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int T = rd.nextInt();
        int N = rd.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextInt();
        }
        int M = rd.nextInt();
        int arr2[] = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = rd.nextInt();
        }
        Long A[] = new Long[N * (N + 1) / 2];
        Long B[] = new Long[M * (M + 1) / 2];
        int idxA = 0;
        int idxB = 0;

        for (int i = 0; i < N; i++) {
            long sum = arr[i];
            A[idxA++] = sum;
            for (int j = i + 1; j < N; j++) {
                sum += arr[j];
                A[idxA++] = sum;
            }
        }
        for (int i = 0; i < M; i++) {
            long sum = arr2[i];
            B[idxB++] = sum;
            for (int j = i + 1; j < M; j++) {
                sum += arr2[j];
                B[idxB++] = sum;
            }
        }
        Arrays.sort(A);

        Arrays.sort(B, Collections.reverseOrder());

        long res = 0;
        int ptA = 0;
        int ptB = 0;
        while (ptA < A.length && ptB <B.length) {
            long curA = A[ptA];
            long target = T - curA;
            //curB == taget -> A,B와 같은 수 개수 체크 -> 답구하기, ptA +ptB+
            if (B[ptB] == target) {
                long countA = 0;
                long countB = 0;
                while (ptA < A.length && A[ptA] == curA) {
                    countA++;
                    ptA++;
                }
                while (ptB < B.length && B[ptB] == target) {
                    countB++;
                    ptB++;
                }
                res += countA * countB;

            }
            //curB > target -> ptB++
            else if (B[ptB] > target) {
                ptB++;
            } else {
                ptA++;
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
