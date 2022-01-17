package DAY01.P2580스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    static boolean isValid(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == val) return true;
            if (arr[i][y] == val) return true;
        }
        x = x / 3 * 3;
        y = y / 3 * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (arr[i][j] == val) return true;
            }
        }
        return false;
    }

    static void DFS(int row, int col) {


        if (col == 9) {
            DFS(row + 1, 0);
            return;
        }
        if (row == 9) {
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    sb.append(anInt + " ");

                }
                sb.append("\n");
            }
            System.out.println(sb);

            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (!isValid(row, col, i)) {
                    arr[row][col] = i;
                    DFS(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        DFS(row, col + 1);

    }


    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = rd.nextInt();
            }
        }
        DFS(0, 0);
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
