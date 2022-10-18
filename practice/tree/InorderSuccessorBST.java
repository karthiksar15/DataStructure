package practice.tree;

import java.util.*;

class BSTNode {
    public long val;
    public BSTNode left;
    public BSTNode right;
    public BSTNode parent;

    public BSTNode(long val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class InorderSuccessorBST {


    public static int inorderSuccessor(BSTNode root, BSTNode givenNode) {
        Deque<BSTNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val > givenNode.val)
                return (int) root.val;
            root = root.right;
        }
        return -1;
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
        int key = sc.nextInt();
        BSTNode key_node = new BSTNode(key);
        System.out.println(inorderSuccessor(root, key_node));
    }

}


//    Problem Description
//    Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree. You may assume that each parent has a link to its child.
//
//        Input format
//        The tree will be given along with the node for which you have to find the successor.
//
//        Q: Q number of queries will be given to you.
//
//        Output format
//        Print the value of the successor node. If it doesn’t exist then print -1.
//
//        Sample Input 1
//        3
//
//        5 4 6
//
//        0 1 2
//
//        1 -1 -1
//
//        2 -1 -1
//
//        2
//
//        2
//
//        0
//
//        Sample Output 1
//        -1
//
//        6
//
//        Explanation 1
//        The tree given in the sample will look like -
//
//        image
//
//        There will be no successor of node with value 6.
//
//        The successor of node having value 5 will be the node with value 6.
//
//        Constraints
//        1<= Number of nodes <= 20000
//
//        1<= Q <= 10000
//
//        Resources
//        Inorder Successor in a BST