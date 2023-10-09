package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationK {

    private int n;
    private int k;

    public static void main(String[] args) {
        CombinationK com=new CombinationK();
        System.out.println(com.combine(4,2));

    }

    public List<List<Integer>> combine(int n,int k)
    {
        this.k=k;
        this.n=n;
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> numList=new ArrayList<>();
        backtrack(list,1,numList);
        return numList;
    }
    public void backtrack(List<Integer> curr, int firstNum, List<List<Integer>> comb)
    {
        if(curr.size()==k)
        {
            comb.add(new ArrayList<>(curr));
            return;
        }
        int need=k-curr.size();
        int remain=n-firstNum+1;
        int available=remain-need;
        for(int num=firstNum;num<=firstNum+available;num++)
        {
            curr.add(num);
            backtrack(curr,num+1,comb);
            curr.remove(curr.size()-1);
        }
    }
}
