package practice.binarysearch;

import java.util.Scanner;

public class FindNthRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int x = sc.nextInt();
            int n = sc.nextInt();
            int ans = nthRoot(x, n);
            System.out.println(ans);
        }
    }

    static int nthRoot(int x, int n) {
        // Initialize boundary values
        double low, high;
        if (x >= 0 && x <= 1) {
            low = x;
            high = 1;
        } else {
            low = 1;
            high = x;
        }
        if (n == 1)
            return x;
        // used for taking approximations
        // of the answer
        double epsilon = 0.0000001;
        // Do binary search
        double guess = (low + high) / 2;
        while (Math.abs(high - low) >= epsilon) {
            if (Math.pow(guess, n) > x) {
                high = guess;
            } else {
                low = guess;
            }
            guess = (low + high) / 2;
        }
        return (int) Math.floor(guess + epsilon);
    }
}
//    Problem Description
//    You are given a X positive integer. You need to find the N-th root of X.
//
//        If the N-th root is in decimal you need to print its floor value e.g, floor(3.23) = 3.
//
//        Input format
//        First line contains T i.e, the number of test cases.
//
//        Each test case has a single line that contains two positive integers, X and N.
//
//        Output format
//        For each test case print the floor(N-th root of X) in a new line.
//
//        Sample Input 1
//        4
//
//        4 2
//
//        9 3
//
//        11 2
//
//        16 4
//
//        Sample Output 1
//        2
//
//        2
//
//        3
//
//        2
//
//        Explanation
//        For X = 4 and N = 2 => (4) ^ (1/2) = 2. And floor(2) = 2
//
//        For X = 9 and N = 3 => (9) ^ (1/3) = 2.08. And floor(2.08) = 2
//
//        For X = 11 and N = 2 => (11) ^ (1/2) = 3.316. And floor(3.316) = 3
//
//        For X = 16 and N = 4 => (16) ^ (1/4) = 2. And floor(2) = 2
//
//        Constraints
//        1 <= T <= 10 ^ 4
//
//        1 <= X <= 10 ^ 9
//
//        1 <= N <= 10 ^ 4
//
//        Resources
//        Calculating n-th real root using binary search
