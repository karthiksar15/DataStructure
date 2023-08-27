package recursion;


class TreeNode{

    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val,TreeNode left,TreeNode right)
    {
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

public class BST {

    public static TreeNode bst(TreeNode root,int val)
    {
        if(root==null||root.val==val)
            return root;

        return val<root.val?bst(root.left,val):bst(root.right,val);
    }



    public static void main(String[] args) {
        TreeNode node=new TreeNode(2,null,null);
        TreeNode node1=new TreeNode(1,null,null);
        TreeNode node2=new TreeNode(33,null,null);
        node.left=node1;
        node.right=node2;
        TreeNode node3=new TreeNode(25,null,null);
        TreeNode node4=new TreeNode(40,null,null);
        node2.left=node3;
        node2.right=node4;
        TreeNode node5=new TreeNode(11,null,null);
        node3.left=node5;
        TreeNode node6=new TreeNode(34,null,null);
        node4.left=node6;
        TreeNode node7=new TreeNode(12,null,null);
        TreeNode node8=new TreeNode(7,null,null);
        node5.left=node8;
        node5.right=node7;
        TreeNode node9=new TreeNode(13,null,null);
        node7.right=node9;
        TreeNode node10=new TreeNode(36,null,null);
        node6.right=node10;

        System.out.println(bst(node,12).val);


    }
}
