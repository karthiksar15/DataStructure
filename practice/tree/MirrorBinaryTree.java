package practice.tree;

import java.util.*;

public class MirrorBinaryTree {
    public static TreeNode mirrorView(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Do BFS. While doing BFS, keep swapping
        // left and right children
        while (q.size() > 0) {
            // pop top node from queue
            TreeNode curr = q.peek();
            q.remove();

            // swap left child with right child
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            // push left and right children
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
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
        TreeNode bt = mirrorView(mp.get(1));
        Stack<TreeNode> q = new Stack<>();
        while (true) {
            while (bt != null) {
                q.push(bt);
                bt = bt.left;
            }
            TreeNode temp = q.pop();
            System.out.println(temp.val);
            if (temp.right != null) {
                q.push(temp.right);
            }
            if (q.isEmpty())
                break;

        }
    }
}

//    Problem Description
//    Given a binary tree, return the root of the mirror binary tree. Mirror binary tree of a binary tree is a binary tree with left and right children of all nodes interchanged.
//
//        image
//
//        Input format
//        First line contains an integer t - Number of test cases.
//
//        First line of each test case contains an integer n - Number of nodes.
//
//        Second line of each test case contains n integers - Value of nodes.
//
//        Next n lines contain 3 space separated integers i, l, r describing left and right child of ith node as l and r respectively.
//
//        Output format
//        Print the inorder traversal of the mirror tree in a separate line for each test case.
//
//        Sample Input 1
//        2
//
//        4
//
//        10 5 9 7
//
//        1 2 3
//
//        2 -1 -1
//
//        3 4 -1
//
//        4 -1 -1
//
//        3
//
//        4 9 3
//
//        1 2 3
//
//        2 -1 -1
//
//        3 -1 -1
//
//        Sample Output 1
//        9 7 10 5
//
//        3 4 9
//
//        Explanation
//        First test case:
//
//        image
//
//        Second test case:
//
//        image
//
//        Constraints
//        1 <= t <= 10
//
//        1 <= n <= 10^5
//
//        1 <= value of nodes <= 10000
//
//        Resources
//        Mirror a binary tree