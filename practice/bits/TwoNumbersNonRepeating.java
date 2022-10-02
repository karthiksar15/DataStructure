package practice.bits;

import java.util.Scanner;

public class TwoNumbersNonRepeating {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans[] = twoNonRepeatingNumbers(nums);
        System.out.println(ans[0] + " " + ans[1]);
        sc.close();
    }

    private static int[] twoNonRepeatingNumbers(int[] nums) {
        int xor = 0, pos = 0, x = 0, y = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        for (int i = 0; i < 32; i++) {
            if (((xor) & (1 << i)) > 0) {
                pos = i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i]) & (1 << pos)) > 0) {
                x = x ^ nums[i];
            } else {
                y = y ^ nums[i];
            }
        }
        if (x < y) {
            result[0] = x;
            result[1] = y;
        } else {
            result[0] = y;
            result[1] = x;
        }
        return result;
    }

}


//    Problem Description
//    Given an array in which all numbers except two are repeated once. (i.e. we have 2k+2 numbers and k numbers are occurring twice and remaining two have occurred once).
//
//        Find those two numbers in the most efficient way. Return the two numbers in a sorted manner.
//
//        Input format
//        First line of input contains N which denotes the number of elements in the input array.
//
//        The next line of input contains N space separated integers.
//
//        Output format
//        Return the two numbers which are present only once in the array in a sorted manner(i.e smaller number first).
//
//        Sample Input 1
//        8
//
//        2 3 7 9 11 2 3 11
//
//        Sample Output 1
//        7 9
//
//        Explanation
//        All numbers except 7 and 9 are repeated once.
//
//        Constraints
//        2<=N<=100000
//
//        1<=arr[i]<=100000