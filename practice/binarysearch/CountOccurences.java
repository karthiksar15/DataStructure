package practice.binarysearch;


import java.util.Scanner;

public class CountOccurences {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int res = countOccurrences(n, k, a);

        System.out.println(res);
    }

    static int countOccurrences(int n, int k, int a[]) {
        if (n == 1 && k == a[0])
            return 1;
        else if (n == 1 && k != a[0])
            return 0;

        int last = lastOccurence(n, k, a);
        int first = firstOccurence(n, k, a);
        if (last == -1 && first == -1) {
            return 0;
        }
        int count = last - first + 1;
        return count;
    }

    static int firstOccurence(int n, int k, int[] a) {
        int index = -1, left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (k == a[mid]) {
                index = mid;
                right = mid - 1;
            } else if (k > a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    static int lastOccurence(int n, int k, int[] a) {
        int index = -1, left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (k == a[mid]) {
                index = mid;
                left = mid + 1;
            } else if (k > a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}

//    Problem Description
//    Given a sorted integer array of length n with possible duplicate elements. Find the number of occurrences of an integer k using binary search.
//
//        Input format
//        There are 2 lines of input.
//
//        First line contains 2 space separated integers n, k - Number of elements, the integer k.
//
//        Second line contains n space separated integers - The integer array.
//
//        Output format
//        Print the number of occurrences of the integer k.
//
//        Sample Input 1
//        5 2
//
//        -1 2 2 4 7
//
//        Sample Output 1
//        2
//
//        Explanation 1
//        The integer 2 occurs 2 times in the given array.
//
//        Constraints
//        1 <= n <= 10^6
//
//        -10^9 <= k <= 10^9
//
//        -10^9 <= A[i] <= 10^9
//
//        Resource
//        Count number of occurrences (or frequency) in a sorted array
//        Video : Count occurrences of a number in a sorted array with duplicates using Binary Search

