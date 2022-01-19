package DAY03.P10828스택;

import java.io.*;
import java.util.*;

public class Main {
    static int top = -1;
    static int size;
    static int arr[] = new int[10005];
    static StringBuilder sb = new StringBuilder();

    static void push(int x) {
        arr[++top] = x;
    }

    static int top() {
        if (isEmpty()) return 0;
        return arr[top];
    }

    static int size() {
        return top + 1;
    }

    static void pop() {
        if (isEmpty()) sb.append(-1+"\n");
        else sb.append(arr[top--]+"\n");
    }

    static boolean isEmpty() {
        return top == -1 ? true : false;
    }

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        size = rd.nextInt();
        while (size != 0) {
            size--;
            String str = rd.next();
            if (str.equals("push")) {
                int x = rd.nextInt();
                push(x);
            } else if (str.equals("pop")) {
                pop();
            } else if (str.equals("size")) {
                sb.append(size()+"\n");
            } else if (str.equals("empty")) {
                if (isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            } else {
                int x=top();
                if(x==0) sb.append(-1+"\n");
                else sb.append(x+"\n");
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

            double nextDouble() {
                return Double.parseDouble(next());
            }

            long nextLong() {
                return Long.parseLong(next());
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
