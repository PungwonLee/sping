package DAY03.P2243사탕상자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static int S;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();

        for (S = 1; S < 1000000; S *= 2) ;
        tree = new int[S * 2];

        for (int i = 0; i < N; i++) {
            if (rd.nextInt() == 2) {        //맛 , 더할 갯수
                updateBU(rd.nextInt(), rd.nextInt());
            } else {                        //순위넣고 N순위의 맛은?
                QueryUD(1, rd.nextInt());
            }
        }
        System.out.println(sb);
    }

    static void QueryUD(int v, int queryVal) {
        tree[v] -= 1;
        if (v >= S) {
            sb.append(v - S + 1+"\n");
            return;
        }
        int left = v * 2;
        int right = v * 2 + 1;
        if (tree[left] >= queryVal) {
            QueryUD(left, queryVal);
        } else {
            QueryUD(right, queryVal - tree[left]);
        }
    }
    static void updateBU(int idx, int count) {
        int X = S + idx - 1;
        tree[X] += count;
        X /= 2;
        while (X > 0) {
            tree[X] = tree[X * 2] + tree[X * 2 + 1];
            X /= 2;
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
