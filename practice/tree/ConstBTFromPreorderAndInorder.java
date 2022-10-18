package practice.tree;

import java.util.*;

public class ConstBTFromPreorderAndInorder {

    static Set<TreeNode> set = new HashSet<>();
    static Stack<TreeNode> stack = new Stack<>();

    public static TreeNode constructBinaryTreeFromPreorderAndInorderTraversal(int[] preorder, int[] inorder) {
        TreeNode root = null;
        for (int pre = 0, in = 0; pre < preorder.length; ) {
            TreeNode node = null;
            do {
                node = new TreeNode(preorder[pre]);
                if (root == null)
                    root = node;
                if (!stack.isEmpty()) {
                    if (set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.pop().right = node;
                    } else {
                        stack.peek().left = node;
                    }
                }
                stack.push(node);

            } while (preorder[pre++] != inorder[in] && pre < preorder.length);
            node = null;
            while (!stack.isEmpty() && in < inorder.length && stack.peek().val == inorder[in]) {
                node = stack.pop();
                in++;
            }
            if (node != null) {
                set.add(node);
                stack.push(node);
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int index = 1;
//        Map<Integer, TreeNode> mp = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            long val = sc.nextLong();
//            TreeNode tn = new TreeNode(val);
//            mp.put(index, tn);
//            index++;
//        }
//        for (int i = 1; i <= len; i++) {
//            int node = sc.nextInt();
//            TreeNode temp = mp.get(node);
//            int left = sc.nextInt();
//            if (left != -1)
//                temp.left = mp.get(left);
//            int right = sc.nextInt();
//            if (right != -1)
//                temp.right = mp.get(right);
//        }

        ;
        int in[] = new int[]{5, 4, 2, 1, 3, 6};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        TreeNode temp = constructBinaryTreeFromPreorderAndInorderTraversal(pre, in);
        System.out.println(temp.val);
    }
}


//    Problem Description
//    Given preorder and inorder traversal of a tree, construct the binary tree.
//
//        Note: You may assume that duplicates do not exist in the tree.
//
//        Input format
//        First line contains N, the number of elements in the tree.
//
//        Next line contains N space separated integers, denoting preorder.
//
//        Next line contains N space separated integers, denoting inorder.
//
//        Output format
//        Print two lines by traversing the constructed binary tree.
//
//        First line should contain N space separated integers, denoting preorder.
//
//        Second line should contain N space separated integers, denoting inorder.
//
//        Sample Input 1
//        6
//
//        1 2 4 5 3 6
//
//        5 4 2 1 3 6
//
//        Sample Output 1
//        1 2 4 5 3 6
//
//        5 4 2 1 3 6
//
//        Explanation 1
//        The output writes out the preorder and inorder sequence by traversing the binary tree constructed, so it should be the same as the output.
//
//        Resources
//        Construct a binary tree