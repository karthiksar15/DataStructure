package practice.tree;

import java.util.*;

public class ValidateBST {

    public static boolean validateBinarySearchTree(TreeNode node) {
//        BSTNode node = buildBST(root);
        List<Long> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (true) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            if (st.isEmpty())
                break;
            node = st.pop();
            if (list.contains(node.val))
                return false;
            list.add(node.val);
            node = node.right;
        }
        System.out.println(list);
        long prev = -1;
        for (long num : list) {
            if (num < prev)
                return false;
            prev = num;
        }
        return true;
    }

    public static BSTNode buildBST(TreeNode root) {
        BSTNode node = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            node = insert(temp.val, node);
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        return node;
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
        System.out.println(validateBinarySearchTree(mp.get(1)));
    }
}
//    Problem Description
//    Given a binary tree, determine if it is a valid binary search tree (BST).
//
//        Assume a BST is defined as follows:
//
//        The left subtree of a node contains only nodes with values less than the node's value.
//
//        The right subtree of a node contains only nodes with values greater than the node's value.
//
//        Both the left and right subtrees must also be binary search trees.
//
//        Input format
//        Line1: Number of Test cases (T)
//
//        Line2 to X: First Test Case’s binary tree structure (refer section below for the format)
//
//        LineX+1 to Y: Second Test Case’s binary tree structure and so on.
//
//        Output format
//        Print "Yes" if the tree is a valid BST, else print "No", for every Test Case on a separate line.
//
//        Constraints
//        1 <= T <= 1000
//
//        1<= Number of Nodes <= 10000
//
//        0 <= Node values <= 10^5
//
//        It is guaranteed that the sum of Number of tree nodes across all test cases will be less than 500000.
//
//        Sample Input 1
//        1
//
//        3
//
//        2 1 3
//
//        1 2 3
//
//        2 -1 -1
//
//        3 -1 -1
//
//        Sample Output 1
//        Yes
//
//        Explanation 1
//        image
//
//        The root node's value is 2 which is greater than 1 and lesser than 3. Therefore it is a valid BST.
//
//        Sample Input 2
//        1
//
//        5
//
//        5 1 4 3 6
//
//        1 2 3
//
//        2 -1 -1
//
//        3 4 5
//
//        4 -1 -1
//
//        5 -1 -1
//
//        Sample Output 2
//        No
//
//        Explanation 2
//        image
//
//        The root node's value is 5 which is greater than 4. This violates the condition of a valid BST. Therefore it is not a valid BST
//
//        Resources
//        Validate BST
//        Instructions to create custom input for a Binary Tree
//        In order to specify a binary tree that can be used as custom input to the problem, you’ll need to follow this convention.
//
//        Line 1: Number of nodes in the Binary Tree (N)
//
//        Line 2: N space separated node values. The position of the Nodes on this line will be used to refer to them in the below lines, starting from 1.
//
//        Line 3 to N+2: Lines specifying the child nodes for each of the N nodes
//
//        Format of each line (space separated): Parent_node Left_child_node Right_child_node
//
//        Parent_node - Node at this Position on Line 2 is the Node to which we are assigning the Left and Right child here
//
//        Left_child_node - Node at this position on Line 2 is the left child. Specify -1 if there is no Left child.
//
//        Right_child_node - Node at this position on Line 2 is the right child. Specify -1 if there is no Right child.
//
//        Example1
//        image
