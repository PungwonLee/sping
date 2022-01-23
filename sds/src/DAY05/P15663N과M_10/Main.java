package DAY05.P15663N과M_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int arr[], select[], check[];
    static HashSet<String> hs = new LinkedHashSet<>();

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        M = rd.nextInt();
        arr = new int[N];
        select = new int[M];
        check = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextInt();
        }
        Arrays.sort(arr);
        func(0, -1);
        for (String h : hs) {
            System.out.println(h);
        }
    }

    private static void func(int v, int s) {
        if (v == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int i : select) {
                sb2.append(i + " ");
            }
            hs.add(sb2.toString());
        } else {
            for (int i = s + 1; i < N; i++) {
                select[v] = arr[i];
                func(v + 1, i);
            }
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
