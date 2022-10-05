package practice.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int res = longestPalindrome(n, s);

        System.out.println(res);
    }

    static int longestPalindrome(int n, String s) {
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int cnt = 0, mod_cnt = 0, one_cnt = 0, grt_cnt = 0;
        boolean one_flag = false, multi_flag = false;
        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> mp_1 : mp.entrySet()) {
            Integer v = mp_1.getValue();
            Character k = mp_1.getKey();
            if (v % 2 == 0) {
                cnt = cnt + v;
            } else if (v == 1 && (!one_flag) && (!multi_flag)) {
                one_flag = true;
            } else if (v > 1) {
                cnt = cnt + v - 1;
                multi_flag = true;
            }

        }
        if (multi_flag)
            cnt = cnt + 1;
        if (one_flag && (!multi_flag))
            cnt = cnt + 1;


        return cnt;
    }
}


//    Problem Description
//    You are given a string consisting of lower and upper case characters.
//        You need to find the length of the longest palindrome which you can create by using the characters from the string.
//        Note: Upper case and lower case characters are different from each other i.e, "Aa" is not a palindrome as 'A' != 'a'.
//
//        Input format
//        There are 2 lines of input
//
//        First line contains the size of the string
//
//        Second line contains the string.
//
//        Output format
//        Print the length of the longest palindrome possible.
//
//        Sample Input 1
//        4 bbde
//
//        Sample Output 1
//        3
//
//        Explanation
//        The possible 3 size palindrome strings are :- beb and bdb
//
//        Constraints
//        1 <= Size of String <= 10^4
//
//        Resource
//        Video : Longest Palindrome
//
//        Find longest palindrome formed by removing or shuffling chars from string