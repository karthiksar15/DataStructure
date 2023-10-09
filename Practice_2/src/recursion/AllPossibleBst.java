package recursion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair
{
    Integer i1;
    Integer i2;
    public Pair(Integer i1,Integer i2)
    {
        this.i1=i1;
        this.i2=i2;
    }
}

public class AllPossibleBst {


    public List<TreeNode> allPossibleBst(int start, int end, Map<Pair,List<TreeNode>> memo)
    {
       List<TreeNode> res=new ArrayList<>();
       if(start>end)
       {
           res.add(null);
           return  res;
       }
       if(memo.containsKey(new Pair(start,end))){
           return memo.get(new Pair(start,end));
       }
        for (int i = start; i <=end ; i++) {
            List<TreeNode> leftSubTrees=allPossibleBst(start,i-1,memo);
            List<TreeNode> rightSubTrees=allPossibleBst(i+1,end,memo);

            for (TreeNode left:leftSubTrees)
            {
                for(TreeNode right:rightSubTrees)
                {
                    TreeNode root=new TreeNode(i,left,right);
                    res.add(root);
                }
                
            }
        }
        memo.put(new Pair(start,end),res);
        return  res;
    }
    public List<TreeNode> generateTrees(int n) {
        Map<Pair,List<TreeNode>> memo = new HashMap<>();
        return allPossibleBst(1, n, memo);
    }



    public static void main(String[] args) {
        AllPossibleBst apb=new AllPossibleBst();
        apb.generateTrees(3);

    }
}
