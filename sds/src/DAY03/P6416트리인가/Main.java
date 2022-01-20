package DAY03.P6416트리인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    final static int size=100000;
    static int[] visit = new int[size];
    static int[] check = new int[size];
    static int[] dist = new int[size];
    static ArrayList<Integer>[] arrayList;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        StringBuilder sb = new StringBuilder();
        arrayList = new ArrayList[size];
        init();
        int k = 0;
        while (true) {

            int u, v;
            u = rd.nextInt();
            v = rd.nextInt();
            if (u < 0 && v<0) break;
            else if (u == 0&& v==0) {
                k++;
                boolean flag = true;
                for (int i = 0; i < size; i++) {
                    if (dist[i] >= 2) flag = false;
                }
                for (int i = 0; i < size; i++) {
                    if (check[i] == 1&& dist[i]==0) {
                        dfs(i);
                        break;
                    }
                }
                for (int i = 0; i < size; i++) {
                    if (check[i] == 1) {
                        flag = false;
                    }
                }
                if (flag) {
                    sb.append("Case " + k + " is a tree.\n");
                } else {
                    sb.append("Case " + k + " is not a tree.\n");
                }

                init();
            } else {
                arrayList[u].add(v);
                arrayList[v].add(u);
                dist[v] += 1;
                check[u]=1;
                check[v]=1;
                visit[v] = 1;

            }
        }
        System.out.println(sb);
    }

    static void init() {
        visit = new int[size];
        dist = new int[size];
        check = new int[size];

        for (int i = 0; i < size; i++) {
            arrayList[i] = new ArrayList<>();
            visit[i] = 0;
            dist[i] = 0;
            check[i]=0;
        }
    }

    static void dfs(int v) {
        visit[v] = 0;
        check[v]=0;
        for (Integer i : arrayList[v]) {
            if (visit[i] == 1) {
                dfs(i);
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
