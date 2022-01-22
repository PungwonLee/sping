package DAY02.P2842집배원한상덕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int dist[][];
    static int visit[][];
    static char map[][];
    static ArrayList<Integer> high = new ArrayList<>();
    static int startX, startY, cntK;
    static int dx[] = {0, 0, 1, -1, -1, -1, 1, 1};
    static int dy[] = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        map = new char[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = rd.nextLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'P') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'K') {
                    cntK++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = rd.nextInt();
                if (!high.contains(dist[i][j])) {
                    high.add(dist[i][j]);
                }
            }
        }
        Collections.sort(high);

        int l = 0, r = 0, min = Integer.MAX_VALUE;
        while (r < high.size() && l < high.size()) {
            if (BFS(l, r)) {
                min = Math.min(min, (high.get(r) - high.get(l)));
                l++;
            } else {
                r++;
            }

        }
        System.out.println(min);
    }

    static boolean BFS(int l, int r) {
        if (!(high.get(l) <= dist[startX][startY] && dist[startX][startY] <= high.get(r))) return false;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startX);
        q.add(startY);
        visit = new int[N][N];
        visit[startX][startY] = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 8; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (!(0 <= xx && xx < N && 0 <= yy && yy < N)) continue;
                if (visit[xx][yy] != 0) continue;
                if (!(high.get(l) <= dist[xx][yy] && dist[xx][yy] <= high.get(r))) continue;
                if (map[xx][yy] == 'K') cnt++;
                visit[xx][yy] = 1;
                q.add(xx);
                q.add(yy);
            }
        }
        return cnt == cntK ? true : false;

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
