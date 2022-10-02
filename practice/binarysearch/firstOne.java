package practice.binarysearch;

import java.util.Scanner;

public class firstOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = zeroOnes(n, a);
        System.out.println(res);

    }

    public static int zeroOnes(int n, int a[]) {
        int find = 1;
        int found = -1;
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (find == a[mid]) {
                found = mid;
                r = mid - 1;
            } else if (a[mid] < find) {
                l = mid + 1;
            } else {
                r = mid - 1;

            }
        }
        return found;


    }
}


//    Problem Description
//    Given a sorted array consisting of 0s and 1s only, find the index of the first 1. If there’s no 1 present in the array, return -1
//
//        Input format
//        There are 2 lines of input
//
//        First line will contain a single integer n.
//
//        Next line will contain n space separated integers.
//
//        Output format
//        Print the index of first occuring if present, otherwise print -1.
//
//        Sample Input 1
//        4
//
//        0 0 1 1
//
//        Sample Output 1
//        2
//
//        Constraints
//        1<=n<=100000
//
//        0<=Ai<=1
//
//        Resource
//        Find the index of first 1 in a sorted array of 0's and 1's