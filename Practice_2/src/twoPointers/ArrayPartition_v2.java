package twoPointers;

public class ArrayPartition_v2 {

    public int arrayPairSum(int[] nums) {
        int k = 10000;
        int[] count = new int[2 * k + 1];
        for (int i = 0; i < nums.length; i++) {
            count[k + nums[i]]++;
        }
        int sum = 0;
        boolean even = true;
        for (int i = 0; i < 2 * k; i++) {
            while (count[i] > 0) {
                sum += even ? i-k : 0;
                even = !even;
                count[i]--;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        ArrayPartition_v2 ap = new ArrayPartition_v2();
        int[] nums = {1, 4, 3, 2};
        System.out.println(ap.arrayPairSum(nums));

    }
}
