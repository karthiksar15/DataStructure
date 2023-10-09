package Practice_2.src.recursion;

class TreeNode
{
    public TreeNode left;
    public TreeNode right;
    public Integer val;
    public TreeNode(Integer val)

    {
        this.val=val;
    }
}

public class SameTree {


    public boolean isValid(TreeNode tn1,TreeNode tn2)
    {
          if((tn1!=null && tn2==null) || (tn1==null && tn2!=null))
              return false;
          if(tn1==null && tn2==null)
              return true;
          if(tn1!=null && tn2!=null && tn1.val==tn2.val)
               return true;
              return isValid(tn1.left,tn2.left) && isValid(tn1.right,tn2.right);
    }
    public static void main(String[] args) {

        SameTree st=new SameTree();
        TreeNode tn1=new TreeNode(1);
        TreeNode tn2=new TreeNode(2);
        TreeNode tn3=new TreeNode(3);
        tn1.left=tn2;
        tn1.right=tn3;
        TreeNode tn4=new TreeNode(1);
        TreeNode tn5=new TreeNode(2);
        TreeNode tn6=new TreeNode(3);
        tn4.left=tn6;
        tn4.right=tn5;

        System.out.println(st.isValid(tn1,tn4));



    }
}
