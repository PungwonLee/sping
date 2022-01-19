package DAY02.P2517달리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static Person[] people;
    static int S;
    static int N;
    static int[] res;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        StringBuilder sb = new StringBuilder();
        N = rd.nextInt();
        people = new Person[N];
        res = new int[N];
        for (int i = 0; i < N; i++) {
            people[i] = new Person(i + 1, rd.nextInt());
        }
        for (S = 1; S < N; S *= 2) ;
        tree = new int[S * 4];

        Arrays.sort(people);

        for (int i = 0; i < N; i++) {

            updateBU(people[i].idx);
            res[people[i].idx-1] = sumBU(1, people[i].idx);
        }
        for (int re : res) {
            sb.append(re + "\n");
        }
        System.out.println(sb);
    }

    static int sumBU(int left, int right) {
        int leftPos = S + left - 1;
        int rightPos = S + right - 1;
        int sum = 0;

        while (leftPos <= rightPos) {
            if (leftPos % 2 != 0) {
                sum += tree[leftPos++];
            }
            if (rightPos % 2 == 0) {
                sum += tree[rightPos--];
            }
            leftPos /= 2;
            rightPos /= 2;
        }
        return sum;
    }

    static void updateBU(int idx) {
        int x = S + idx - 1;
        tree[x] = 1;

        x /= 2;
        while (x > 0) {
            tree[x] = tree[x * 2] + tree[x * 2 + 1];
            x /= 2;
        }
    }

    static class Person implements Comparable<Person> {
        int idx;
        int val;

        public Person(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "idx=" + idx +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(o.val, val);
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
