package DAY03.P1991트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Tree {
        char left;
        char right;

        public Tree(char left, char right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static class Node {
        Node left = null;
        Node right = null;
        char name;

        public Node(char name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", name=" + name +
                    '}';
        }
    }


    public static void main(String[] args) {
        FastReader rd = new FastReader();
        Tree tree[] = new Tree[27];
        int N = rd.nextInt();
        for (int i = 0; i < N; i++) {
            String[] s = rd.nextLine().split(" ");
            tree[s[0].charAt(0) - 'A'] = new Tree(s[1].charAt(0), s[2].charAt(0));
        }

        Node node[] = new Node[27];
        for (int i = 0; i < 26; i++) {
            node[i] = new Node((char) ('A' + i));
        }
        for (int i = 0; i < N; i++) {
            if (tree[i] != null) {
                if (tree[i].left != '.') {
                    node[i].left = node[tree[i].left - 'A'];
                }
                if (tree[i].right != '.') {
                    node[i].right = node[tree[i].right - 'A'];
                }
            }
        }

        preorder(node[0]);
        System.out.println();
        inorder(node[0]);
        System.out.println();
        postorder(node[0]);
    }

    static void preorder(Node node) {
        if (node != null) {
            System.out.print(node.name);
            preorder(node.left);
            preorder(node.right);
        }
    }

    static void inorder(Node node) {
        if (node != null) {

            inorder(node.left);
            System.out.print(node.name);
            inorder(node.right);
        }
    }

    static void postorder(Node node) {
        if (node != null) {

            postorder(node.left);
            postorder(node.right);
            System.out.print(node.name);
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
