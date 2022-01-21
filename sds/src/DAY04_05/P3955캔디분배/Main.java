package DAY04_05.P3955캔디분배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader rd= new FastReader();
        int N= rd.nextInt();
        while(N--!=0){
            int X =rd.nextInt();
            int Y = rd.nextInt();
            if(Y==1){
                if(X+1 >Math.pow(10,9)){
                    System.out.println("IMPOSSIBLE");
                }else{
                    System.out.println(X+1);
                }
                continue;
            }
            if(X==1){
                System.out.println(1);
                continue;
            }
            EGResult egResult = extendedGCD(X, Y);
            if(egResult.r!=1){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(egResult.t);
            }
        }
    }

    static EGResult extendedGCD(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long tmp;
        while (r1 != 0) {
            long q = r0 / r1;
            tmp = r0 - q * r1; // == r0%r1
            r0 = r1;
            r1 = tmp;

            tmp = s0 - q * s1;
            s0 = s1;
            s1 = tmp;

            tmp = t0 - q * t1;
            t0 = t1;
            t1 = tmp;

            s0=(s0%a+a)%a;
            t0=(t0%a+a)%a;

        }
        return new EGResult(s0,t0,r0);
    }

    static class EGResult {
        long s, t, r;

        public EGResult(long s, long t, long r) {
            this.s = s;
            this.t = t;
            this.r = r;
        }

        @Override
        public String toString() {
            return "EGResult{" +
                    "s=" + s +
                    ", t=" + t +
                    ", r=" + r +
                    '}';
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
