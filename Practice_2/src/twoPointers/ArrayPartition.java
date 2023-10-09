package twoPointers;

import java.util.Arrays;

public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, i = 0, j = nums.length - 2;
        while (i < j) {
            sum = sum + nums[i] + nums[j];
            i += 2;
            j -= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayPartition ap = new ArrayPartition();
        int[] nums = {1, 4, 3, 2};
        System.out.println(ap.arrayPairSum(nums));

    }
}
