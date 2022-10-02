package practice.binarysearch;

import java.util.Scanner;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while (q > 0) {
            int target = scanner.nextInt();
            int result = new SearchInSortedRotatedArray().search(nums, target);
            System.out.println(result);
            q--;
        }
    }

    public int search(int[] nums, int target) {
        int pivot = 0;
        // if(nums.length>1)
        pivot = findPivot(nums);
//        System.out.println("pivot----" + pivot);
        int left = 0, right = nums.length - 1;
        int mod = 1000000007;
        // System.out.println("pivot---"+nums[pivot]);
        if (pivot != -1) {
            if (nums[pivot] == target)
                return pivot;
            else if (target <= nums[pivot] && target >= nums[left])
                right = pivot;
            else if (pivot + 1 <= right && target >= nums[pivot + 1] && target <= nums[right])
                left = pivot + 1;

        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int findPivot(int[] nums) {
        int pivot = nums.length - 1;
        int low = 0, high = nums.length - 1;
        if (nums.length == 1)
            return pivot;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid + 1 <= nums.length - 1 && mid - 1 >= 0 && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
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
//    An array sorted in ascending order is rotated about a pivot unknown to you. Such an array is referred to as a rotated sorted array or a sorted-pivoted array. For example : [1,2,3,4,5] is a sorted array while [3,4,5,1,2] is a rotated sorted array.
//
//
//        You are given a rotated sorted array, and some integer values. You have to find each value’s location in the array. If the value is present, return the index in which it is stored ( 0 based indexing) , otherwise if not found return -1.
//
//
//        Assume the array doesn’t have duplicates.
//
//        Input format
//        There are Q+3 lines of input.
//
//        First line will have a single integer N denoting the size of the array.
//
//        Second line will contain N space separated integers.
//
//        Third line will contain a single integer Q denoting the number of targets to be searched..
//
//        Next Q lines will have a single integer,X in each line denoting the target value. You have to search for each of these target values in turn.
//
//        Output format
//        One line per output for each target search, with -1 or the index at which the integer is found.
//
//        Function Definition
//        Complete the function search in the code editor for a language of your choice.
//
//        search has the following parameters :
//
//        nums : An array of numbers having its values in a rotated sorted order
//
//        target : An integer representing the number to be searched in nums
//
//        search returns :
//
//        int : An integer denoting the index of the target to be searched. If target not present returns -1.
//
//        Constraints
//        1 <= N <= 10^6 where N denotes the size of the input array
//
//        1 <= A[i] <= 10^9 where A[i] denotes the ith element of the input array
//
//        1 <= Q <= 10^6 where Q denotes the number of targets to be searched
//
//        1 <= X <= 10^9 where X denotes the target element to be search
//
//        Sample Input 1
//        7
//
//        4 5 6 9 10 2 3
//
//        2
//
//        3
//
//        8
//
//        Sample Output 1
//        6
//
//        -1
//
//        Explanation 1
//        The element 3 is found in the array at index 6. Element 8 is not found in the array, thus -1.
//
//        Sample Input 2
//        6
//
//        5 6 8 1 3 4
//
//        1
//
//        0
//
//        Sample Output 2
//        -1
//
//        Explanation 2
//        The element 0 is not found in the array.
//
//        Resource
//        Search an element in a sorted and rotated array