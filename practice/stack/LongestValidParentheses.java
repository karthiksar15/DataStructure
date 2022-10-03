package practice.stack;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int ans = longestValidParentheses(S);
        System.out.println(ans);
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        int len = 0, max_len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.size() == 0)
                    st.push(i);
                len = i - st.peek();
                max_len = Math.max(max_len, len);
            }

        }
        return max_len;
    }
}


//    Problem Description
//    Given a string S containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//        Input format
//        First line contains a string - The string S.
//
//        Output format
//        Print the length of the longest valid substring.
//
//        Sample Input 1
//        ()(()(())
//
//        Sample Output 1
//        6
//
//        Explanation
//        The last 6 characters of the string forms the longest valid substring i.e. "()(())".
//
//        Constraints
//        0 <= length of string <= 10^5
//
//        Resource
//        Length of the longest valid substring