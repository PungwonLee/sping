package DAY01.P15686치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;

    static Point[] select;
    static ArrayList<Point> chic = new ArrayList<>();
    static ArrayList<Point> home = new ArrayList<>();


    static void DFS(int v,int s) {
        if (v == M) {
           int sum2=0;
            for (Point ho : home) {
                int sum=Integer.MAX_VALUE;
                for (Point se : select) {
                    int dist=Math.abs(se.x-ho.x)+Math.abs(se.y-ho.y);
                    sum=Math.min(dist,sum);
                }
                sum2+=sum;
            }

            min=Math.min(min,sum2);
        } else {
            for (int i = s; i < chic.size(); i++) {
                    select[v] = chic.get(i);
                    DFS(v + 1,i+1);


            }
        }
    }

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        M = rd.nextInt();
        select = new Point[M];

        for (int i = 0; i < N; i++) {
            String[] tokens = rd.nextLine().split(" ");

            for (int j = 0; j < N; j++) {
                if (tokens[j].charAt(0) == '2') {
                    chic.add(new Point(i, j));
                } else if (tokens[j].charAt(0) == '1') {
                    home.add(new Point(i, j));
                }
            }
        }
        DFS(0,0);
        System.out.println(min);

    }

    static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
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
