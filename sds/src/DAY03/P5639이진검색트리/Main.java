package DAY03.P5639이진검색트리;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Node tree = new Node(Integer.parseInt(br.readLine()));
            String input = "";

            while ((input = br.readLine()) != null) {
                tree.insert(Integer.parseInt(input));
            }
            preorder(tree);
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    static void preorder(Node node) {
        if (node != null) {
            preorder(node.left);
            preorder(node.right);
            System.out.println(node.val);
        }
    }

    static class Node {
        Node left, right;
        int val;

        public void insert(int val) {
            if(this.val>val){
                if(left!=null) left.insert(val);
                else left=new Node(val);
            }else{
                if(right!=null) right.insert(val);
                else right= new Node(val);
            }
        }

        public Node(int val) {
            this.val = val;
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
