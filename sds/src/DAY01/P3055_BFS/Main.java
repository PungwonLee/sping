package DAY01.P3055_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] arr;
    static int[][] dist;
    static int endX;
    static int endY;
    static int startX;
    static int startY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        M = rd.nextInt();
        arr = new char[N][M];
        dist = new int[N][M];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] tokens = rd.nextLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = tokens[j].charAt(0);
                if (arr[i][j] == '*') {
                    q.add(i);
                    q.add(j);
                    dist[i][j]=-1;
                } else if (arr[i][j] == 'D') {
                    endX = i;
                    endY = j;
                } else if (arr[i][j] == 'S') {
                    startX=i;
                    startY=j;

                }
            }
        }
        q.add(startX);
        q.add(startY);
        dist[startX][startY]=1;

        while (!q.isEmpty()) {

            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (!(0 <= xx && xx < N && 0 <= yy && yy < M)) continue;
                if (arr[x][y]=='D'||arr[xx][yy] == 'X' || dist[xx][yy] != 0) continue;

                if (arr[x][y] == '*'&& arr[xx][yy]!='D') {
                    arr[xx][yy] = '*';
                    dist[xx][yy]=-1;
                    q.add(xx);
                    q.add(yy);
                } else {
                    dist[xx][yy] = dist[x][y] + 1;
                    q.add(xx);
                    q.add(yy);
                }
            }

        }
        if(dist[endX][endY]!=0) {
            System.out.println(dist[endX][endY]-1);
        }else{
            System.out.println("KAKTUS");
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
