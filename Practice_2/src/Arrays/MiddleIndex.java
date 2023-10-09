package Arrays;

public class MiddleIndex {

    public int findMiddleIndex(int[] nums) {
        int[] lsum = new int[nums.length];
        int[] rsum = new int[nums.length];
        lsum[0] = nums[0];
        rsum[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            lsum[i] = lsum[i - 1] + nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rsum[i] = rsum[i + 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (lsum[i] == rsum[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        MiddleIndex mi = new MiddleIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {2,1,-1};
         System.out.println(mi.findMiddleIndex(nums));
    }
}
