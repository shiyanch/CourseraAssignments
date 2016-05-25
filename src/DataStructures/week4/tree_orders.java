package DataStructures.week4;

import java.util.*;
import java.io.*;

public class tree_orders {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeOrders {
        int n;
        int[] key, left, right;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            key = new int[n];
            left = new int[n];
            right = new int[n];
            for (int i = 0; i < n; i++) {
                key[i] = in.nextInt();
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
        }

        List<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            inOrder_recursive(0, result);
            return result;
        }

        void inOrder_recursive(int root, ArrayList<Integer> result) {
            if(root == -1)
                return;

            inOrder_recursive(left[root], result);
            result.add(key[root]);
            inOrder_recursive(right[root], result);
        }

        List<Integer> preOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            preOrder_recursive(0, result);
            return result;
        }

        void preOrder_recursive(int root, ArrayList<Integer> result) {
            if(root == -1)
                return;

            result.add(key[root]);
            preOrder_recursive(left[root], result);
            preOrder_recursive(right[root], result);
        }

        List<Integer> postOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            postOrder_recursive(0, result);
            return result;
        }

        void postOrder_recursive(int root, ArrayList<Integer> result) {
            if(root == -1)
                return;

            postOrder_recursive(left[root], result);
            postOrder_recursive(right[root], result);
            result.add(key[root]);
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_orders().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void print(List<Integer> x) {
        for (Integer a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        TreeOrders tree = new TreeOrders();
        tree.read();
        print(tree.inOrder());
        print(tree.preOrder());
        print(tree.postOrder());
    }
}
