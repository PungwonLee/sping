package DAY03.P4358생태학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader rd= new FastReader();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> hm= new HashMap<>();
        String input="";
        int size=0;
        while(true){
            input=br.readLine();
            if(input==null|| input.length()==0|| input.equals(""))break;
            size++;
            if(hm.containsKey(input)){
               hm.put(input,hm.get(input)+1);
            }else{
                hm.put(input,1);
            }
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (Entry<String, Integer> entry : list) {
            System.out.printf("%s %.4f\n",entry.getKey(),entry.getValue()/((double)size)*100);
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
