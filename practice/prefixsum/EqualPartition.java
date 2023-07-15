package practice.prefixsum;

import java.util.Scanner;

public class EqualPartition {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        int res = equalPartition(n, arr);
        System.out.println(res);
    }

    public static int equalPartition(int n, long[] arr) {
//        int result=-1;
        return 0;

    }
}

//    Problem Description
//    Partitioning an array means to split an array along an element, such that it divides the array into two parts with some specific property. The element that partitions the array is called the partitioning element.
//
//        Given an array, find the element, partitioning along which, the sum of elements to its left, equals the sum of elements to its right. The partition element itself is to be excluded from both sums.
//
//        Return the index of the partitioning element. If no such element exists, return -1.
//
//        Input format
//        There are N+1 lines of input.
//
//        First line will contain a single integer N.
//
//        Second line will contain n space separated integer representing array elements.
//
//        Output format
//        Output the index of the partitioning element.
//
//        Constraints
//        2 <= N <= 10^6
//
//        1 <= Arr[i] <= 10^9
//
//        Sample Input 1
//        4
//
//        1 4 2 5
//
//        Sample Output 1
//        2
//
//        Explanation 1
//        Since 1 + 4 = 5 where 2 is such an element.
//
//        Resource
//        Find an element in array such that sum of left array is equal to sum of right array