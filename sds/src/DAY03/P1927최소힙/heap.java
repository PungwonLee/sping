package DAY03.P1927최소힙;

import java.io.*;
import java.util.*;

public class heap {


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

    public static void main(String[] args) {
        MinHeap pq= new MinHeap();

    }
}

class MinHeap {
    List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
        list.add(0);    //인덱스 0번은 안쓰기 때문에 삽입
    }

    public void insert(int val) {
        // 1. leaf 마지막에 삽입
        list.add(val);
        // 2. 부모와 비교 후 조건에 맞지 않으면 Swap
        int child = list.size() - 1;
        int parent = child / 2;

        while (true) {
            if (parent == 0 || list.get(parent) <= list.get(child)) {
                break;
            }
            int tmp = list.get(parent);
            list.set(parent, list.get(child));
            list.set(child, tmp);

            child = parent;
            parent = child / 2;
        }
        // 3. 조건이 만족되거나 root 까지 반복

    }

    public int delete() {
        if (list.size() == 1) {
            return 0;
        }
        int top = list.get(1);

        // 1. Root 에 leaf 마지막 데이터 가져옴
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        // 2. 자식과 비교 후 조건이 맞지 않으면 swap
        // 3. 조건이 만족되거나 leaf 까지 반복
        int parent = 1;
        while (true) {
            int leftChild = parent * 2;
            int rightChild = parent * 2 + 1;

            //왼쪽 자식확인 >>동시에 오른쪽도 확인 >> 없으면 자식존재X 종료조건!
            if (leftChild >= list.size()) {
                break;
            }
            //왼쪽자식 먼저 담기
            int minValue = list.get(leftChild);
            int minPos = leftChild;

            // 오른쪽 자식이 존재하고 왼쪽자식보다 작으면 minValue와 minPos에 오른쪽자식에 대한 정보 저장
            if (rightChild < list.size() && list.get(rightChild) < minValue) {
                minValue = list.get(rightChild);
                minPos = rightChild;
            }
            //
            if (list.get(parent) > minValue) {
                int tmp = list.get(parent);
                list.set(parent, minValue);
                list.set(minPos, tmp);
                parent = minPos;
            }else{
                break;
            }

        }

        return top;
    }
}