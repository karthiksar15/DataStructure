package twoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[nums.length];
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(target - nums[i])) {
                results[count] = mp.get(target - nums[i]);
                count++;
                results[count] = i;
                count++;
            }
            mp.put(nums[i], i);
        }
        return results ;

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {4, 2, 5, 9, 8};
        int[] resul=twoSum.twoSum(nums, 7);
        for(int i:resul)
            System.out.println(i);
    }
}
