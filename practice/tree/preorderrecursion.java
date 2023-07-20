package practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode1 {
    public long val;
    public TreeNode1 left;
    public TreeNode1 right;

    public TreeNode1(long x) {
        val = x;
        left = null;
        right = null;
    }
}

public class preorderrecursion {
    public static void main(String[] args) {

    }

    private List<List<Integer>> list=new ArrayList<>();
    Queue<TreeNode1> qq=new LinkedList<>();


    public void dfs(TreeNode1 root)
    {
//      if(root==null)
//          return;
//      list.add(root.val);
//      dfs(root.left);
//      dfs(root.right);
        List<Integer> sublist=new ArrayList<>();

        list.add(new ArrayList<Integer>(sublist));
    }
    public List<List<Integer>> inorderTraversal(TreeNode1 root) {
        dfs(root);
        return list;

    }
}
