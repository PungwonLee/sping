package DAY03.P1927최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();
        StringBuilder sb = new StringBuilder();

        int N = rd.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        while (N != 0) {
            N--;
            int x = rd.nextInt();
            if (x == 0) {
                if (q.isEmpty()) sb.append(0);
                else sb.append(q.poll());
                sb.append("\n");
            } else {
                q.add(x);
            }
        }
        System.out.println(sb);

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
