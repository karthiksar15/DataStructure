package practice;


import java.util.ArrayList;
import java.util.List;

class Pairs {
    Integer val;
    Integer cnt;

    public Pairs(Integer val, Integer cnt) {
        this.val = val;
        this.cnt = cnt;
    }
}

public class FilterStream {

    public static void main(String[] args) {
        List<Pairs> pqLst = new ArrayList<Pairs>();
        List<Integer> freqLst = new ArrayList<Integer>();
        int nums[]={1,5,4,6,6,7};
        for (int i = 0; i < nums.length; i++) {
            int val_check = nums[i];
            Pairs pp = pqLst.stream().filter(pair -> val_check == pair.val).findAny().orElse(null);
            if (pp == null) {
                pqLst.add(new Pairs(nums[i], 1));
            } else {
                pqLst.remove(pp);
                pp.cnt = pp.cnt + 1;
                pqLst.add(pp);
            }
            // pq.add(nums[i]);
            // if(pqLst.contains(Pair))
        }
        for (Pairs pr : pqLst) {
            System.out.println("val---" + pr.val);
            System.out.println("cnt----" + pr.cnt);
        }
    }
}
