package practice.tree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LcaBst {
    public static TreeNode LcaBst(TreeNode root, long val1, long val2) {
        while (root != null) {
            if (root.val > val1 && root.val > val2)
                root = root.left;
            else if (root.val < val1 && root.val < val2)
                root = root.right;
            else
                break;
        }
        return root;
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

        Long val1 = sc.nextLong();
        Long val2 = sc.nextLong();

        TreeNode temp = LcaBst(mp.get(1), val1, val2);
        System.out.println(temp.val);
    }
}


//    Problem Description
//    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//        The lowest common ancestor is defined between two nodes p and q as the lowest node in the tree that has both p and q as descendants (where we allow a node to be a descendant of itself).
//
//        Input format
//        First line contains an integer n - Number of nodes.
//
//        Second line contains n space separated integers - The value of nodes.
//
//        Next n lines contain 3 space separated integers i, l, r describing left and right child of ith node as l and r respectively.
//
//        Last line contains two integers p and q - The given nodes.
//
//        Output format
//        Output an integer - The value of the LCA node.
//
//        Sample Input 1
//        7
//
//        40 20 60 10 30 50 70
//
//        1 2 3
//
//        2 4 5
//
//        3 6 7
//
//        4 -1 -1
//
//        5 -1 -1
//
//        6 -1 -1
//
//        7 -1 -1
//
//        30 60
//
//        Sample Output 1
//        40
//
//        Explanation
//        The binary search tree is:-
//
//        image
//
//        The node 40 is the lowest node which has both 30 & 60 as its descendants.
//        Sample Input 2
//        4
//
//        3 1 4 2
//
//        1 2 3
//
//        2 -1 4
//
//        3 -1 -1
//
//        4 -1 -1
//
//        2 4
//
//        Sample Output 2
//        3
//
//        Explanation
//        The binary search tree is:-
//
//        image
//
//        Constraints
//        1 <= N <= 10^5
//
//        1 <= Values of the Nodes <= 10^9
//
//        Resources
//        LCA in a BST
//
//        Checklist