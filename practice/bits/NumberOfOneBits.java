package practice.bits;

import java.util.Scanner;

class NumberOfOneBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int ans = numberOfOneBits(n);
        System.out.print(ans);
    }

    static int numberOfOneBits(long n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}


//    Problem Description
//    Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
//
//        Input format
//        Single line containing one 32-bit unsigned integer N.
//
//        Output format
//        Single line containing number of 1 bits in N.
//
//        Sample Input 1
//        5
//
//        Sample Output 1
//        2
//
//        Explanation 1
//        Binary representation of 5 is:
//
//        101
//
//        Hence total number of 1 bits = 2
//
//        Constraints
//        0<=N<=2^32-1
//
//        Resource
//        Hamming weight problem