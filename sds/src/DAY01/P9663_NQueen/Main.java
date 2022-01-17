package DAY01.P9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int cnt;
    static int[] col=new int[15];

    static boolean isAttack(int r1, int c1, int r2, int c2) {
        if (c1 == c2|| r1==r2) return true;
        if (c1 + r1 == c2 + r2) return true;
        if (r1 - c1 == r2 - c2) return true;
        return false;
    }

    static void DFS(int v) {
        if (v == N) {
            cnt += 1;
        } else {
            for (int c = 0; c < N; c++) {
                boolean flag = true;

                for (int i = 0; i < v; i++) {
                    if (isAttack(v, c, i, col[i])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    col[v]=c;
                    DFS(v + 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        DFS(0);
        System.out.println(cnt);

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
