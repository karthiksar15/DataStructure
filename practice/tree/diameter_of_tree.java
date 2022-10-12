package practice.tree;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TreeNode {
    long val;
    TreeNode left;
    TreeNode right;

    public TreeNode(long val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Height {
    int height;
}

public class diameter_of_tree {

    public static int diameterOfBinaryTree(TreeNode root) {
        Height h = new Height();
        return diameterOpt(root, h);
    }

    public static int diameterOpt(TreeNode root, Height h) {
        Height lh = new Height();
        Height rh = new Height();
        if (root == null) {
            h.height = 0;
            return 0;
        }

        int ldiameter = diameterOpt(root.left, lh);
        int rdiameter = diameterOpt(root.right, rh);
        h.height = Math.max(ldiameter, rdiameter) + 1;
        return Math.max(lh.height + rh.height, Math.max(ldiameter, rdiameter));
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
        System.out.println(diameterOfBinaryTree(mp.get(1)));
    }

}
//    Problem Description
//    Given the root of a binary tree, return the length of the diameter of the tree.
//
//        The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//        The length of a path between two nodes is represented by the number of edges between them.
//
//        Input format
//        First line contains an integer n - Number of nodes.
//
//        Second line contains n space separated integers - The value of nodes.
//
//        Next n lines contain 3 space separated integers i, l, r describing left and right child of ith node as l and r respectively.
//
//        Output format
//        Print an integer - The length of the diameter.
//
//        Sample Input 1
//        8
//
//        10 15 25 12 40 16 8 9
//
//        1 5 3
//
//        5 6 -1
//
//        6 -1 7
//
//        7 -1 -1
//
//        3 2 4
//
//        2 8 -1
//
//        8 -1 -1
//
//        4 -1 -1
//
//        Sample Output 1
//        6
//
//        Explanation
//        The binary tree is:-
//
//        image
//
//        The path 8->16->40->10->25->15->9 has 6 edges in it and is the longest path in the given tree.
//
//        Constraints
//        1 <= N <= 10^5
//
//        1 <= Values of the Nodes <= 10^9
//
//        Resources
//        Diameter of a Binary Tree