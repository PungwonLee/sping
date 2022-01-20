package DAY03.P9202Boggle;

import java.io.*;
import java.util.*;


public class Main {
    static Node root = new Node();
    static int dx[] = {0, 0, 1, -1, -1, -1, 1, 1};
    static int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};
    static int score[] = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    static int N;
    static int M;
    static char arr[][];
    static int visit[][];
    static int cnt;
    static int sum;
    static String maxStr = "";

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        StringBuilder sb = new StringBuilder();

        N = rd.nextInt();
        for (int i = 0; i < N; i++) {
            root.insert(rd.nextLine());
        }
        M = rd.nextInt();
        while (M-- != 0) {
            arr = new char[5][5];
            visit = new int[4][4];
            for (int i = 0; i < 4; i++) {
                String[] split = rd.nextLine().split("");
                if (split.length != 4) {
                    i--;
                    continue;
                }
                for (int j = 0; j < split.length; j++) {
                    arr[i][j] = split[j].charAt(0);
                }
            }

            cnt = 0;
            sum = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (root.child[arr[i][j] - 'A'] != null) {
                        dfs(root.child[arr[i][j] - 'A'], i, j, "" + arr[i][j]);
                    }
                }

            }
            sb.append(sum + " " + maxStr + " " + cnt + "\n");
            init(root);
            maxStr = "";
        }
        System.out.println(sb);
    }

    static void init(Node node) {
        for (int i = 0; i < 26; i++) {
            node.isHit = false;
            if (node.child[i] != null) {
                init(node.child[i]);
            }
        }
    }

    static void dfs(Node node, int x, int y, String str) {

        visit[x][y] = 1;
        if (node.isEnd && !node.isHit) {
            node.isHit = true;
            sum += score[str.length()];
            cnt++;
            if (str.length() > maxStr.length()) {
                maxStr = str;
            } else if (str.length() == maxStr.length() && maxStr.compareTo(str) > 0) {
                maxStr = str;
            }
        }

        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (!(0 <= xx && xx < 4 && 0 <= yy && yy < 4)) continue;
            if (node.child[arr[xx][yy] - 'A'] == null || visit[xx][yy] == 1) continue;
            dfs(node.child[arr[xx][yy] - 'A'], xx, yy, str + arr[xx][yy]);

        }
        visit[x][y] = 0;
    }

    static class Node {
        Node child[] = new Node[26];
        boolean isEnd;
        boolean isHit;

        public void insert(String str) {
            if (str.length() == 0) {
                isEnd = true;
                return;
            }
            if (child[str.charAt(0) - 'A'] == null) {
                child[str.charAt(0) - 'A'] = new Node();
            }
            child[str.charAt(0) - 'A'].insert(str.substring(1));
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
