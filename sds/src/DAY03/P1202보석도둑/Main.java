package DAY03.P1202보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        int K = rd.nextInt();
        int arr[][] = new int[N][2];
        int bag[] = new int[K];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            arr[i]= new int[]{rd.nextInt(),rd.nextInt()};

        }
        for (int i = 0; i < K; i++) {
            bag[i] = rd.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        Arrays.sort(bag);
        long res = 0;
        int idx=0;
        for (int i = 0; i < K; i++) {
            while(idx<N && arr[idx][0]<= bag[i]){
                pq.add(arr[idx++]);
            }
            if(!pq.isEmpty())
                res+=pq.poll()[1];
        }
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
