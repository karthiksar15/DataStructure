package practice.tree;

import java.util.*;

public class BoundaryTraversalOfATree {
    private static boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    public static void addLeftBound(TreeNode root, ArrayList<Long> ans) {
        root = root.left;
        while (root != null) {
            if (!isLeaf(root)) {
                ans.add(root.val);
            }
            if (root.left != null)
                root = root.left;
            else
                root = root.right;
        }
    }

    public static void addRightBound(TreeNode root, ArrayList<Long> ans) {
        root = root.right;
        Stack<Long> st = new Stack<>();
        while (root != null) {
            if (!isLeaf(root)) {
                st.push(root.val);
            }
            if (root.right != null)
                root = root.right;
            else
                root = root.left;
        }
        while (!st.isEmpty()) {
            ans.add(st.pop());
//            st.pop();
        }
    }

    public static void addLeaves(TreeNode root, ArrayList<Long> ans) {
        if (root == null) return;
        if (isLeaf(root)) {
            ans.add(root.val); // just store leaf nodes
            return;
        }

        addLeaves(root.left, ans);
        addLeaves(root.right, ans);

    }

    public static ArrayList<Long> boundaryTraversal(TreeNode root) {
        ArrayList<Long> ans = new ArrayList<>();
        if (root == null)
            return ans;
        if (!isLeaf(root))
            ans.add(root.val);
        addLeftBound(root, ans);
        addLeaves(root, ans);
        addRightBound(root, ans);
        return ans;
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
        System.out.println(boundaryTraversal(mp.get(1)));
    }
}

//    Problem Description
//    Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. The boundary includes left boundary, leaves, and right boundary in order.
//
//        The left boundary is defined as the path from the root to the left-most node. The right boundary is defined as the path from the root to the right-most node. If the root doesn’t have a left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not to any subtrees.
//
//        The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if it exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
//
//        The right-most node is also defined in the same way with left and right exchanged.
//
//        Example:-
//
//        image
//
//        The output for this tree would be 1,2,4,5,6 and 3.
//
//        Input format
//        First line contains an integer n - Number of nodes.
//
//        Second line contains n space separated integers - The value of nodes.
//
//        Next n lines contain 3 space separated integers i, l, r describing left and right child of ith node as l and r respectively.
//
//        Output format
//        Output space separated values of the nodes.
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
//        10 40 16 8 9 12 25
//
//        Explanation
//        The binary tree is:-
//
//        image
//
//        Boundary traversal starts from the root node i.e. 10 then the left boundary i.e. 10, 40, 16, 8, the leaf nodes i.e. 8, 9, 12 and finally the right boundary i.e. 12, 25, 10. We won't take a particular node twice so the final answer after ignoring the repeated nodes would be - 10, 40, 16, 8, 9, 12, 25.
//
//        Sample Input 2
//        4
//
//        1 2 3 4
//
//        1 2 -1
//
//        2 -1 3
//
//        3 4 -1
//
//        4 -1 -1
//
//        Sample Output 2
//        1 2 3 4
//
//        Explanation
//        The binary tree is:-
//
//        image
//
//        The left boundary for this tree is 1, 2, 3, 4.
//
//        4 is the only leaf node and the right boundary consists only of the root node.
//
//        Constraints
//        1 <= N <= 10^5
//
//        1 <= Values of the Nodes <= 10^9
//
//        Resources
//        Boundary Traversal of a Tree