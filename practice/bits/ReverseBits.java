package practice.bits;

import java.util.Scanner;

public class ReverseBits {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        long t = input.nextLong();
        while (t-- > 0) {
            long num = input.nextLong();
            long ans = reverseBits(num);
            System.out.print(ans);
        }

    }

    public static long reverseBits(long num) {
        long rev = 0;
        int count = 32;
        while (count > 0) {
            rev <<= 1;
            if ((num & 1) == 1)
                rev ^= 1;
            num >>= 1;
            count--;
        }
        return rev;

    }
}


//    Problem Description
//    Reverse the bits of a given 32 bits unsigned integer.
//
//        Input format
//        First line contains the number of test cases.
//
//        Each line contains a 32 bit unsigned integer.
//
//        Output format
//        Output the Reversed unsigned integer.
//
//        Sample Input 1
//        1
//
//        43261596
//
//        Sample Output 1
//        964176192
//
//        Explanation 1
//        The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 whose binary representation is 00111001011110000010100101000000.
//
//
//        Constraints
//        1 <= T <= 10^5
//
//        0 <= N <= 2^32-1
//
//        Resource
//        Reverse bits of a given number