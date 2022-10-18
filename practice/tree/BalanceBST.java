package practice.tree;

import java.util.*;

public class BalanceBST {

    public static BSTNode balanceBST(BSTNode node) {
        List<Long> list = new ArrayList<>();
        Stack<BSTNode> st = new Stack<>();
        while (true) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            if (st.isEmpty())
                break;
            node = st.pop();
            if (!list.contains(node.val))
                list.add(node.val);
            node = node.right;
        }
        long new_root = list.get(list.size() / 2);
        list.remove(new_root);
        BSTNode temp = null;
        temp = insert(new_root, temp);
        for (long num : list) {
            temp = insert(num, temp);
        }
        return temp;

    }

    public static BSTNode insert(long val, BSTNode root) {
        BSTNode current = root;
        BSTNode new_node = new BSTNode(val);
        int flag = 0;
        if (root == null) {
            root = new_node;
        } else {
            BSTNode temp = null;
            while (current != null) {
                temp = current;
                new_node.parent = temp;
                if (val <= current.val) {
                    flag = 0;
                    current = current.left;
                } else {
                    flag = 1;
                    current = current.right;
                }
            }
            if (flag == 0)
                temp.left = new_node;
            else
                temp.right = new_node;
        }
        return root;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        BSTNode root = null;
        for (int i = 0; i < len; i++) {
            long val = sc.nextLong();
            root = insert(val, root);
        }
        BSTNode temp = balanceBST(root);
        temp.toString();

    }
}


//    Problem Description
//    Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
//
//        A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
//
//        Input format
//        First line contains an integer T - Number of test cases.
//
//        For each test case:-
//
//        First line contains an integer n - Number of nodes.
//
//        Second line contains n space separated integers - The value of nodes.
//
//        Next n lines contain 3 space separated integers i, l, r describing left and right child of ith node as l and r respectively.
//
//        Output format
//        Output the balanced tree in the same format as given in input.
//
//        Note: You just have to return the balanced tree’s root, the input/output is handled.
//
//        Sample Input 1
//        1
//
//        4
//
//        40 20 10 30
//
//        1 2 -1
//
//        2 3 4
//
//        3 -1 -1
//
//        4 -1 -1
//
//        Sample Output 1
//        1
//
//        4
//
//        20 10 30 40
//
//        1 2 3
//
//        2 -1 -1
//
//        3 -1 4
//
//        4 -1 -1
//
//        Explanation
//        The initial binary search tree is:-
//
//        image
//
//        Balanced binary search tree is:-
//
//        image
//
//        Constraints
//        1 <= T <= 100
//
//        1 <= N <= 1000
//
//        1 <= Values of the Nodes <= 10^9
//
//        Resources
//        Balance a BST