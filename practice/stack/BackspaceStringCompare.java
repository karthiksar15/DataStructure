package practice.stack;

import java.util.Scanner;
import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            String S = sc.next();
            String T = sc.next();

            boolean res = backspaceStringCompare(S, T);

            if (res)
                System.out.println(true);
            else
                System.out.println(false);

        }
    }

    static boolean backspaceStringCompare(String S, String T) {
        Stack<Character> charSt = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#' && charSt.size() > 0)
                charSt.pop();
            else if (c != '#')
                charSt.push(c);
        }
        Stack<Character> charSt_1 = new Stack<Character>();
        for (char c : T.toCharArray()) {
            if (c == '#' && charSt_1.size() > 0)
                charSt_1.pop();
            else if (c != '#')
                charSt_1.push(c);
        }
        if (charSt.size() == 0 && charSt_1.size() == 0) {
            return true;
        } else if (charSt.size() == charSt_1.size()) {

            while (charSt.size() > 0 && charSt_1.size() > 0) {
                if (charSt.pop() != charSt_1.pop())
                    return false;
            }
        } else {
            return false;
        }
        return true;
    }
}


//    Problem Description
//Given 2 strings S and T containing lowercase and '#' characters. You have to check whether these 2 strings are same or not when typed into an editor('#' being the backspace character).
//
//
//        Note: Backspacing an empty string remains an empty string only.
//
//        For eg. a#bc means bc, and a##bcd means bcd.
//
//        Input format
//        There are 2t+1 lines of input.
//
//        First line contains an integer tests - Number of test cases.
//
//        First line of each test case contains a string S.
//
//        Second line of each test case contains a string T.
//
//        Output format
//        Print true if the 2 strings are same otherwise false, for each test case print in a different line.
//
//        Function definition
//        You have to complete the given function. It accepts two parameters - the two strings, and returns a boolean value, true if S and T are same and false if not.
//
//        Sample Input 1
//        2
//
//        as#sddff#
//
//        aa#sddf
//
//        a##b
//
//        ab
//
//        Sample Output 1
//        true
//
//        false
//
//        Explanation
//        In first test case both the strings become "asddf" when typed into an editor.
//
//        In second test case the string becomes "b" and "ab" which are not equal.
//
//        Constraints
//        1 <= tests <= 10
//
//        1 <= Length of each string <= 10^5
//
//        Resource
//        Check if two strings after processing backspace character are equal or not