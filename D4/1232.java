import java.io.*;

public class Solution {

    static TreeNode[] tree;
    static int ROOT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(br.readLine());
            tree = new TreeNode[N + 1];

            for(int i=0; i<N; i++) {
                String[] in = br.readLine().split(" ");
                if (in.length == 2) {
                    tree[Integer.parseInt(in[0])] = new TreeNode(Double.parseDouble(in[1]));
                } else if (in.length == 4) {
                    tree[Integer.parseInt(in[0])] = new TreeNode(in[1].charAt(0), Integer.parseInt(in[2]), Integer.parseInt(in[3]));
                }
            }

            bw.write("#" + t + " " + (int)calculateTree(ROOT) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static double calculateTree(int index) {
        TreeNode node = tree[index];
        if(node.isNumber)
            return node.val;

        double left = calculateTree(node.left);
        double right = calculateTree(node.right);

        switch (node.op) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            default:
                return 0;
        }
    }
}

class TreeNode {
    double val;
    char op;
    int left;
    int right;
    boolean isNumber;

    TreeNode(double val) {
        this.val = val;
        this.isNumber = true;
    }
    TreeNode(char op, int left, int right) {
        this.op = op;
        this.left = left;
        this.right = right;
        this.isNumber = false;
    }
}