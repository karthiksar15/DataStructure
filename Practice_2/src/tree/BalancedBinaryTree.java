package tree;

class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(long x) {
        val = x;
        left = null;
        right = null;
    }
}

public class BalancedBinaryTree {

    static int count = 0;

    public int findNumberOfBtVoilations(TreeNode root) {
        balanceHeight(root);
        return count;

    }

    public int balanceHeight(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        // checking left subtree
        int leftSubtreeHeight = balanceHeight(currentNode.left);
        if (leftSubtreeHeight == -1) {
            count += 1;
//            return -1;
        }

        // if left subtree is not balanced then the entire tree is also not balanced

        //checking right subtree
        int rightSubtreeHeight = balanceHeight(currentNode.right);
        if (rightSubtreeHeight == -1) {
            count += 1;
//            return -1;
        }
        // if right subtree is not balanced then the entire          tree is also not balanced

        //checking the difference of left and right subtree for current node
        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
            count += 1;
//            return -1;
        }
        //if it is balanced then return the height
        return (Math.max(leftSubtreeHeight, rightSubtreeHeight)+1 );
    }

    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        TreeNode t1 = new TreeNode(9943);
        TreeNode t2 = new TreeNode(1472);
        TreeNode t3 = new TreeNode(8808);
        t1.left = t2;
        t1.right = t3;

        TreeNode t4 = new TreeNode(6339);
        t2.left = t4;
        t2.right = null;
        TreeNode t5 = new TreeNode(8065);
        TreeNode t6 = new TreeNode(2966);
        t3.left = t5;
        t3.right = t6;
        TreeNode t7 = new TreeNode(9591);
        TreeNode t8 = new TreeNode(8332);
        t4.left = t7;
        t4.right = t8;
        TreeNode t9 = new TreeNode(7633);
        TreeNode t10 = new TreeNode(2240);
        t5.left = t9;
        t5.right = t10;


        t6.left = null;
        t6.right = null;
        t7.left = null;
        t7.right = null;
        t8.left = null;
        t8.right = null;
        t9.left = null;
        t9.right = null;
        t10.left = null;
        t10.right = null;
        System.out.println(bbt.findNumberOfBtVoilations(t1));


    }

}


//10
//        9943 1472 8808 6339 8065 2966 9591 8332 7633 2240
//        1 2 3
//        2 4 -1
//        3 5 6
//        4 7 8
//        5 9 10
//        6 -1 -1
//        7 -1 -1
//        8 -1 -1
//        9 -1 -1
//        10 -1 -1

//1