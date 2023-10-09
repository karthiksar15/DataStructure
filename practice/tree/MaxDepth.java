package practice.tree;


//Problem Description
//        Given a binary tree, find its maximum depth.
//
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//        Note: A leaf is a node with no children.
//
//        Input format
//        T: T number of test cases will be given
//
//        You will be given the root of the tree.
//
//        Output format
//        1<=T<=100
//
//        1<=N<=100000
//
//        Sum of the number of nodes in all test cases will be less than 500000.
//
//        Sample Input 1
//        1
//
//        6
//
//        1 2 3 4 5 6
//
//        1 2 3
//
//        2 4 -1
//
//        3 -1 5
//
//        4 -1 6
//
//        5 -1 -1
//
//        6 -1 -1
//
//        Input Visualization
//        image
//
//        Sample Output 1
//        4
//
//        Explanation
//
//        1->2->4->6 is the maximum depth path in the given tree.
//
//        Constraints
//        Print the maximum height of the tree.


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxDepth {
    static int maximumDepthOfBinaryTree(TreeNode root, int max, int temp) {

        if (root == null) {
            if (max > temp) {
                temp = max;
            }
            max = 0;
            return temp;
        }
        temp=maximumDepthOfBinaryTree(root.left, max + 1, temp);
        temp=maximumDepthOfBinaryTree(root.right, max + 1, temp);
        return temp;

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
        System.out.println(maximumDepthOfBinaryTree(mp.get(1), 0, 0));
    }

}
