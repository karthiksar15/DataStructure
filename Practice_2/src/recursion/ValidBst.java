package recursion;


public class ValidBst {

    Integer prev=null;

    public boolean isValid(TreeNode node) {

        if(node==null)
            return true;
        if(!isValid(node.left))
            return  false;
        if(prev!=null && node.val<=prev)
            return false;
        prev=node.val;
        return isValid(node.right);

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10, null, null);
        TreeNode n2 = new TreeNode(5, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n4 = new TreeNode(7, null, null);
        TreeNode n5 = new TreeNode(15, null, null);
        TreeNode n6 = new TreeNode(13, null, null);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        ValidBst vb=new ValidBst();
        System.out.println(vb.isValid(n1));

    }
}
