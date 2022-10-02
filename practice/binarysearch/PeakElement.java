package practice.binarysearch;

import java.util.Scanner;

public class PeakElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(peakElement(arr));
    }

    static int peakElement(int nums[]) {
        int pivot = nums.length - 1;
        int low = 0, high = nums.length - 1;
        if (nums.length == 1)
            return pivot;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid + 1 <= nums.length - 1 && mid - 1 >= 0 && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else {
                low = low + 1;
            }

        }
        if (nums.length == 2 && nums[0] > nums[1])
            return 0;

        if (nums[0] > nums[pivot])
            return 0;
        else if (nums[pivot] > nums[0])
            return pivot;

        return -1;
    }
}
