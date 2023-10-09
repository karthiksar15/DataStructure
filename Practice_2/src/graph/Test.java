package graph;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Integer num=5;
        Integer num2=15;
        System.out.println(num.equals(num2));

        Map<Integer,Integer> mp=new HashMap<>();
        for(Integer index: List.of(1,2,3,4,5))
        {
            mp.putIfAbsent(1,index);
        }
        int[] num1={1,3,5};
        List<int[]> testLst= Arrays.asList(num1);
        List<Integer> nums=List.of(1,2,3);
        new ArrayList<>(Arrays.asList(num1));

    }
}
