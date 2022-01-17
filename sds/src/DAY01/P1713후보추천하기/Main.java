package DAY01.P1713후보추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int []arr= new int[101];
    public static void main(String[] args) {
        FastReader rd= new FastReader();
        N=rd.nextInt();
        M=rd.nextInt();
        ArrayList<Integer> list= new ArrayList<>();


        for(int i=0;i<M;i++) {

            boolean check = false;
            int n = rd.nextInt();
            for (int j = 0; j < list.size(); j++) {
                if (n == list.get(j)) {
                    arr[n] += 1;
                    check = true;
                }
            }
            if (check) continue;
            if (list.size() >= N) {

                int min = arr[list.get(0)];
                int idx = 101;
                for (int j = 0; j < list.size(); j++) {

                    if (arr[list.get(j)] < min) {
                        min = arr[list.get(j)];
                        idx = j;

                    }
                }
                if(idx!=101){
                    Integer remove = list.remove(idx);
                    arr[remove]=0;
                }
                else{
                    Integer remove = list.remove(0);
                    arr[remove]=0;
                }
                list.add(n);
            } else {
                list.add(n);
            }

        }

        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer+" ");
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
