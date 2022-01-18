package DAY01.P1713후보추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ver2_Sort {
    static int N, K;
    static int[] inputs;
    static Person[] people;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        K = rd.nextInt();

        inputs = new int[K];
        people = new Person[101];

        List<Person> list = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            int num = rd.nextInt();
            if (people[num] == null) {
                people[num] = new Person(num, 0, 0, false);
            }
            // 사진판에 있는 경우 -> count++;
            if (people[num].isIn == true) {
                people[num].count++;
            } else { // 사진판에 없는 경우 - > 하나골라서, 제거 후 새 후보 추가
                if (list.size() == N) {
                    Collections.sort(list);
                    Person p = list.remove(0);
                    p.isIn = false;
                }
                people[num].count = 1;
                people[num].isIn = true;
                people[num].timeStamp = k;
                list.add(people[num]);

            }
            Collections.sort(list, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return Integer.compare(o1.num,o2.num);
                }
            });

            Comparator.comparingInt(Person::getNum);
            Collections.sort(list, (o1, o2) -> Integer.compare(o1.num,o2.num));
            Collections.sort(list, Comparator.comparingInt(o -> o.num));
            //42행~51행 다 같은 정렬 반환값이 한개일때!
            for (Person person : list) {
                System.out.println(person.num);
            }
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

class Person implements Comparable<Person> {
    int num;
    int count;
    int timeStamp;
    boolean isIn;

    public Person(int num, int count, int timeStamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(Person o) {
        int comp1 = Integer.compare(count, o.count);
        if (comp1 == 0) {
            return Integer.compare(timeStamp, o.timeStamp);
        } else {
            return comp1;
        }

    }
}
