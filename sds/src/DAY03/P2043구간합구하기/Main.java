
package DAY03.P2043구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] D;
    static long[] tree;
    static int S;
    static int N, M, K;
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        M = rd.nextInt();
        K = rd.nextInt();
        D = new long[N];
        for (int i = 0; i < N; i++) {
            D[i] = rd.nextLong();
        }

        for (S = 1; S < N; S *= 2) ;
        tree = new long[S * 2];
        initBU();
        for (int i = 0; i < M + K; i++) {
            String[] s = rd.next().split(" ");
            if (s[0].equals("1")) {
                updateBU(rd.nextInt(), rd.nextLong());
            } else {
                sumBU(rd.nextInt(), rd.nextInt());
            }
        }
        System.out.println(sb);
    }

    static void sumBU(int left, int right) {
        int leftPos = left + S - 1;
        int rightPos = right + S - 1;
        long res=0;
        while(leftPos<=rightPos){
            if(leftPos%2==1){
                res+=tree[leftPos++];
            }
            if(rightPos%2==0){
                res+=tree[rightPos--];
            }
            leftPos/=2;
            rightPos/=2;
        }
        sb.append(res+"\n");
    }

    static void updateBU(int idx, long val) {
        int X = S + idx - 1;
        tree[X] = val;
        X /= 2;
        while (X > 0) {
            tree[X] = tree[X * 2] + tree[X * 2 + 1];
            X /= 2;
        }
    }

    static void initBU() {
        for (int i = 0; i < N; i++) {
            tree[S + i] = D[i];
        }
        int idx = S - 1;
        for (int i = idx; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
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
