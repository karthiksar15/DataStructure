package practice.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lca {

    static boolean v1 = false, v2 = false;

    public static TreeNode findLCAUtil(TreeNode node, long n1, long n2) {
        if (node == null)
            return null;
        TreeNode temp = null;
        if (node.val == n1) {
            v1 = true;
            temp = node;
        }
        if (node.val == n2) {
            v2 = true;
            temp = node;
        }
        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCAUtil(node.left, n1, n2);
        TreeNode right_lca = findLCAUtil(node.right, n1, n2);

        if (temp != null)
            return temp;

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;

    }

    static TreeNode findLCA(TreeNode root, long n1, long n2) {
        // Initialize n1 and n2 as not visited
        v1 = false;
        v2 = false;

        // Find lca of n1 and n2 using the technique discussed above
        TreeNode lca = findLCAUtil(root, n1, n2);

        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2)
            return lca;

        // Else return NULL
        return null;
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

        TreeNode temp = findLCA(mp.get(1), val1, val2);
        System.out.println(temp.val);
    }
}


//    Problem Description
//    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. LCA between two nodes p and q is defined as the lowest node in the tree that has both p and q as descendants (where we allow a node to be a descendant of itself)
//
//        Note: For the solution method provided, the input parameters are the nodes p and q, not node values. The return value expected from the method is the LCA node and not the node’s value. The below Input and Output format show node values which the Driver file will take care of; the user doesn’t have to edit the Driver code.
//
//        Input format
//        Line 1 has T: no of test cases given.
//
//        Line 2 to X: First test case details with first set of lines giving the binary tree structure (refer section below for the format) and last line giving two node values (integers) whose LCA node has to be found.
//
//        Line X+1 to Y: Second Test case details and so on.
//
//        Output format
//        Print the value of the node which is the common ancestor of two nodes.
//
//        Constraints
//        1 <= T <= 1000
//
//        1 <= N <= 10000, Number of nodes in the tree
//
//        0 <= Node values <= 10^9
//
//        It is guaranteed that the sum of the number of tree nodes for all test cases will be < 500000.
//
//        Sample Input 1
//        1
//
//        5
//
//        2 3 7 8 9
//
//        1 2 3
//
//        2 4 5
//
//        3 -1 -1
//
//        4 -1 -1
//
//        5 -1 -1
//
//        7 2
//
//        Sample Output 1
//        2
//
//        Explanation 1
//        image
//
//        The LCA of node with value 2 and node with value 7 is the node with value 2.
//
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
//        * Parent_node - Node at this Position on Line 2 is the Node to which we are assigning the Left and Right child here
//
//        * Left_child_node - Node at this position on Line 2 is the left child. Specify -1 if there is no Left child.
//
//        * Right_child_node - Node at this position on Line 2 is the right child. Specify -1 if there is no Right child.
//        Example1
//        image
//
//        Resource
//        https://www.youtube.com/watch?v=k7NF6rNOs4Y&ab_channel=FitCoder
//        Resources
//        LCA in a binary tree