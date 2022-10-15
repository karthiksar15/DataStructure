package practice.tree;

import java.util.*;

class TreeNodeDist extends TreeNode {
    int distance;

    public TreeNodeDist(long val) {
        super(val);
    }
}

public class TopView {


    public static List<Long> topView(TreeNodeDist root) {
        List<Long> list = new ArrayList<>();
        Queue<TreeNodeDist> q = new LinkedList<>();
        q.add(root);
        int distance = 0;
        root.distance = distance;

        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            TreeNodeDist temp = q.poll();
            if (set.add(temp.distance))
                list.add(temp.val);
            if (temp.left != null) {
                distance = temp.distance - 1;
                TreeNodeDist temp_left = (TreeNodeDist) temp.left;
                temp_left.distance = distance;
                q.add(temp_left);
            }
            if (temp.right != null) {
                distance = temp.distance + 1;
                TreeNodeDist temp_right = (TreeNodeDist) temp.right;
                temp_right.distance = distance;
                q.add(temp_right);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int index = 1;
        Map<Integer, TreeNodeDist> mp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            long val = sc.nextLong();
            TreeNodeDist tn = new TreeNodeDist(val);
            mp.put(index, tn);
            index++;
        }
        for (int i = 1; i <= len; i++) {
            int node = sc.nextInt();
            TreeNodeDist temp = mp.get(node);
            int left = sc.nextInt();
            if (left != -1)
                temp.left = mp.get(left);
            int right = sc.nextInt();
            if (right != -1)
                temp.right = mp.get(right);
        }
        System.out.println(topView(mp.get(1)));
    }
}


//    Problem Description
//    You are given a binary tree. You need to find the nodes in order of left to right which will be visible when the tree is viewed from the top.
//
//        Top view :-
//
//        image
//
//        The visible nodes from left to right are 4, 2, 1 and 3.
//
//        Input format
//        First line contains an integer n - Number of nodes.
//
//        Second line contains n space separated integers - The value of nodes.
//
//        Next n lines contain 3 space separated integers i, l, r describing left and right child of ith node as l and r respectively.
//
//        Output format
//        Output space separated values of the nodes visible from top of the tree from left to right.
//
//        Sample Input 1
//        7
//
//        10 15 25 12 40 16 20
//
//        4 -1 -1
//
//        1 5 3
//
//        5 6 -1
//
//        6 -1 7
//
//        2 -1 -1
//
//        3 2 4
//
//        7 -1 -1
//
//        Sample Output 1
//        16 40 10 25 12
//
//        Explanation
//        The binary tree is:-
//
//        image
//
//        The visible nodes from left to right are 16, 40, 10, 25 and 12.
//
//        Constraints
//        1 <= N <= 10^5
//
//        1 <= Values of the Nodes <= 10^9
//
//        Resources
//        Top View of a binary tree