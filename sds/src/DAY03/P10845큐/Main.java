package DAY03.P10845큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] q = new int[10000];
    static int size = 10000;
    static int rear = 0;
    static int front = 1;
    static StringBuilder sb = new StringBuilder();

    static void push(int x) {
        rear = rear + 1;
        q[rear] = x;
    }

    static void pop() {
        if (empty()) sb.append(-1 + "\n");
        else sb.append(q[front++]+"\n");
    }

    static int size() {
        return (rear - front + 1);
    }

    static void front() {
        if (empty()) sb.append(-1 + "\n");
        else sb.append(q[front] + "\n");
    }

    static void back() {
        if (empty()) sb.append(-1 + "\n");
        else sb.append(q[rear] + "\n");
    }

    static boolean empty() {
        return rear + 1 == front ? true : false;
    }

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        while (N != 0) {
            N--;
            String next = rd.next();
            if (next.equals("push")) {
                push(rd.nextInt());
            } else if (next.equals("pop")) {
                pop();
            } else if (next.equals("size")) {
                sb.append(size() + "\n");
            } else if (next.equals("empty")) {
                if (empty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            } else if (next.equals("front")) {
                front();
            } else {
                back();
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
