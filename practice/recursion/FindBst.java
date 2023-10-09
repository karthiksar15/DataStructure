package practice.recursion;

class BST{
    public int val;
    public BST leftNode;
    public BST rightNode;

    public BST(int val)
    {
        this.val=val;
    }
}

public class FindBst {

    public static void main(String[] args) {
        BST root=new BST(4);
        BST node1=new BST(2);
        BST node2=new BST(1);
        BST node3=new BST(3);
        BST node4=new BST(7);
        root.leftNode=node1;
        root.rightNode=node4;
        node1.leftNode=node2;
        node1.rightNode=node3;
        FindBst find=new FindBst();
        BST reslt=find.findSubtree(root,2);
        System.out.println(reslt.val);

    }

    public BST findSubtree(BST root,int val)
    {
        if(root==null || root.val==val)
            return root;
        return val<root.val ? findSubtree(root.leftNode,val) :findSubtree(root.rightNode,val);
    }


}
