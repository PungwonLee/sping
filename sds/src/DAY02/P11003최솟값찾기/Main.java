package DAY02.P11003최솟값찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader rd= new FastReader();
        StringBuilder sb= new StringBuilder();
        int N= rd.nextInt();
        int L= rd.nextInt();
        int arr[]= new int[N];
        for(int i=0;i<N;i++){
            arr[i]=rd.nextInt();
        }
        Deque<int []> q= new LinkedList<>();

        for(int i=0;i<N;i++){
            while(!q.isEmpty()&&q.peekLast()[1] > arr[i]){
                q.pollLast();
            }
            q.addLast(new int[]{i, arr[i]});
            while(q.peekFirst()[0]<=(i-L)){
                q.pollFirst();
            }
            sb.append(q.peekFirst()[1]+" ");
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
