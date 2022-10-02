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


//    Problem Description
//    A peak element is an element that is strictly greater than its neighbors. Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks. You may imagine that nums[-1] = nums[n] = -∞. You must write an algorithm that runs in O(log n) time.
//
//        Input format
//        The first line contains an integer N, the size of the input array. The second line contains N integers, the elements of the given array.
//
//        Output format
//        Return a single integer, the index of the peak element in the array (0-based).
//
//        Sample Input 1
//        4
//
//        1 2 3 1
//
//        Sample Output 1
//        2
//
//        Explanation
//        3 is a peak element and your function should return the index number 2.
//
//        Constraints
//        1 <= nums.length <= 1000
//
//        1 <= nums[i] <= 2^31 - 1
//
//        nums[i] != nums[i + 1] for all valid i
//
//        Resource
//        Video: Peak Element