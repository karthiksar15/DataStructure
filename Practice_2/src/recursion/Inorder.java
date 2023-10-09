import java.util.ArrayList;
import java.util.List;

class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val)
    {
        this.val=val;
    }
}

public class Inorder {

    List<Integer> list=new ArrayList<>();

    public List<Integer> inorder(TreeNode node)
    {
           if(node==null)
           {
               return list;
           }
           list.add(node.val);
           System.out.println(node.val);

           inorder(node.left);
           inorder(node.right);
           return list;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        Inorder in=new Inorder();
        System.out.println(in.inorder(node1));
        


    }
}
