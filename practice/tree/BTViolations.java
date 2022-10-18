package practice.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BTViolations {
    static int violations = 0;

    public static int numberOfViolations(TreeNode root) {
        if (root == null)
            return 0;

        int left = numberOfViolations(root.left);
        int right = numberOfViolations(root.right);
        int height = Math.max(left, right) + 1;
        int diff = Math.max(left, right) - Math.min(left, right);
        if (diff > 1)
            violations++;
        return height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int index = 1;
        Map<Integer, TreeNode> mp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            long val = sc.nextLong();
            TreeNode tn = new TreeNode(val);
            mp.put(index, tn);
            index++;
        }
        for (int i = 1; i <= len; i++) {
            int node = sc.nextInt();
            TreeNode temp = mp.get(node);
            int left = sc.nextInt();
            if (left != -1)
                temp.left = mp.get(left);
            int right = sc.nextInt();
            if (right != -1)
                temp.right = mp.get(right);
        }
        numberOfViolations(mp.get(1));
        System.out.println(violations);

    }
}
