package DAY04.P1837암호제작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean isPrime[];

    public static void main(String[] args) {
        FastReader rd = new FastReader();

        String P = rd.next();
        int K = rd.nextInt();
        isPrime = new boolean[K + 2];
        for (int i = 2; i <= K+1; i++) {
            for (int j = i + i; j <= K+1; j += i) {
                isPrime[j] = true;
            }
        }
        for (int i = 2; i < K; i++)
            if (isPrime[i] == false) {
                int val = 0;
                for (int j = 0; j < P.length(); j++) {
                    val = ( (val*10)+P.charAt(j) - '0')%i;
                }
                if(val==0){
                    System.out.println("BAD "+i);
                    return;
                }
            }
        System.out.println("GOOD");
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
