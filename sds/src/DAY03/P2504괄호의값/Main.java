package DAY03.P2504괄호의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();
        Stack<String> stack = new Stack<>();
        String[] s = rd.nextLine().split("");

        int sum = 1;
        int res = 0;
        for (int i = 0; i < s.length; i++) {

            if (s[i].equals("(") || s[i].equals("[")) {
                stack.push(s[i]);
                if (s[i].equals("(")) sum *= 2;
                if (s[i].equals("[")) sum *= 3;

            } else {
                if(stack.empty()){
                    System.out.println(0);
                    return;
                }
                String pop = stack.pop();
                if (s[i - 1].equals("[") || s[i - 1].equals("(")) {
                    res += sum;
                }
                if (pop.equals("[") && s[i].equals("]")) {
                    sum /= 3;
                } else if (pop.equals("(") && s[i].equals(")")) {
                    sum /= 2;
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }
        if(!stack.empty())res=0;
        System.out.println(res);
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
