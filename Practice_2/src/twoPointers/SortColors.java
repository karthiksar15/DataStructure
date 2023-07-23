package twoPointers;

public class SortColors {

    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (mid <= high) {
            if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, high, mid);
                high--;
            }
        }
        for (int n : nums) {
            System.out.println(n);
        }


    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
//        int[] nums = {1, 1, 1, 2, 2, 0};
        int[] nums = {0, 0, 2, 0, 0, 0, 1, 2, 2, 0, 1, 1, 2, 1, 0, 2, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 2, 2, 1, 0, 2, 1, 0};
        sc.sortColors(nums);
    }
}
