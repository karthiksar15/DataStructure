package practice.tree;

import java.util.*;

public class RightView {

    public static ArrayList<Long> rightView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Long> list = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int s = q.size();
            TreeNode temp = null;
            for (int i = 0; i < s; i++) {
                temp = q.poll();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
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
        System.out.println(rightView(mp.get(1)));
    }
}


//    Problem Description
//    You are given a binary tree.
//
//        You need to find the nodes in order of top to bottom which will be visible when the tree is viewed from the right side.
//
//        Right view :-
//
//        image
//
//        The visible nodes from top to bottom are 1, 3 and 4.
//
//        Input format
//        First line contains an integer n - Number of nodes.
//
//        Second line contains n space separated integers - The value of nodes.
//
//        Next n lines contain 3 space separated integers i, l, r describing left and right child of ith node as l and r respectively.
//
//        Output format
//        Output space separated values of the nodes visible from right side of the tree from top to bottom.
//
//        Sample Input 1
//        6
//
//        10 15 25 12 40 16
//
//        4 -1 -1
//
//        1 5 3
//
//        5 6 -1
//
//        6 -1 -1
//
//        2 -1 -1
//
//        3 2 4
//
//        Sample Output 1
//        10 25 12
//
//        Explanation
//        The binary tree is:-
//
//        image
//
//        The visible nodes from top to bottom are 10, 25 and 12.
//
//        Constraints
//        1 <= N <= 10^5
//
//        1 <= Values of the Nodes <= 10^9
//
//        Resources
//        Right View of a binary tree