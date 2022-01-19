package DAY03.P1655가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader rd= new FastReader();
        StringBuilder sb= new StringBuilder();
        int N= rd.nextInt();
        PriorityQueue<Integer> pqMin= new PriorityQueue<>();
        PriorityQueue<Integer> pqMax= new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));

        for(int i=0;i<N;i++){
            if(i%2==0){
                pqMax.add(rd.nextInt());
            }
            else{
                pqMin.add(rd.nextInt());
            }
            while(!pqMin.isEmpty() && pqMax.peek() > pqMin.peek()){
                int tmp=pqMax.poll();
                pqMax.add(pqMin.poll());
                pqMin.add(tmp);
            }
            sb.append(pqMax.peek());
            sb.append("\n");
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
