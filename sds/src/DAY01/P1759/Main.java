package DAY01.P1759;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static Integer N;
    public static Integer M;
    public static char[] arr;
    public static int[] select;

    public static void DFS(Integer v, Integer mo, Integer ja) {
        if (v == N + 1) {
            if (mo >= 1 && ja >= 2) {
                for (int i = 1; i <= N; i++) {
                    System.out.print(arr[select[i]]);
                }
                System.out.println();
            }
        } else {
            for (int i = select[v - 1] + 1; i <= M; i++) {
                select[v] = i;

                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    DFS(v + 1, mo + 1, ja);
                } else {
                    DFS(v + 1, mo, ja + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        M = rd.nextInt();
        arr = new char[M + 1];
        select = new int[N + 1];

        String[] tokens = rd.nextLine().split(" ");
        for (int i = 1; i <= M; i++) {
            arr[i] = tokens[i - 1].charAt(0);
        }
        Arrays.sort(arr);
        DFS(1, 0, 0);

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
