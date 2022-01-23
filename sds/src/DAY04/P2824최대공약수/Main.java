package DAY04.P2824최대공약수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N, M;

        N = rd.nextInt();

        BigInteger sum = new BigInteger("1");
        BigInteger sum2 = new BigInteger("1");
        for (int i = 0; i < N; i++) {
            sum = sum.multiply(new BigInteger(rd.next()));

        }
        M = rd.nextInt();
        for (int i = 0; i < M; i++) {
            sum2 = sum2.multiply(new BigInteger(rd.next()));
        }

        BigInteger gcd = GCD(sum, sum2);
        if (gcd.compareTo(new BigInteger("1000000000")) >= 0) {

            System.out.printf("%09d", gcd.mod(new BigInteger("1000000000")).longValue());
        } else {
            System.out.println(gcd);
        }

    }

    static BigInteger GCD(BigInteger a, BigInteger b) {
        while (!b.equals(new BigInteger("0"))) {
            BigInteger tmp = a.mod(b);
            a = b;
            b = tmp;
        }
        return a;
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
