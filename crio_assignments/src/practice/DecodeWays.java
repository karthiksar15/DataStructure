package practice;

import java.io.*;
import java.util.*;
class DecodeWays {
    // Implement your Solution Here
    int mod = 1000000007;
    int decodeMessage(int[] dp, int s, String str, int n)
    {

        // an empty string can also form 1 valid decoding
        if(s >= n)
            return 1;

    /*
        if we have already computed the number of
        ways to decode the substring return the
        answer directly
    */
        if(dp[s] != -1)
            return dp[s];

        int num,tc;
        num = tc = 0;
        for(int i=s;i<n;i++)
        {
            // generate the number
            num = num*10 + ((int)str.charAt(i) - '0');

            // validate the number
            if(num >= 1 && num <= 26)
            {
        /*
                since the number of ways to decode any string
                depends on the result of
                how the remaining string is decoded so get the
                number of ways how the rest of the string can
                be decoded
            */
                int c = decodeMessage(dp, i + 1, str, n);

                // add all the ways that the substring
                // from the current index can be decoded
                tc = (tc%mod + c%mod)%mod;
            }

            // leading 0s or the number
            // generated so far is greater than 26
            // we can just stop the process
            // as it can never be a part of our solution
            else
                break;
        }

        return (dp[s] = tc);
    }
    public int numDecodings(String s) {
        int n = s.length();

        if(n == 0)
            return 1;


        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }

        return decodeMessage(dp,0,s,n);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        int result = new DecodeWays().numDecodings(s);
        System.out.println(result);
    }
}

/*
Crio Methodology

Milestone 1: Understand the problem clearly
1. Ask questions & clarify the problem statement clearly.
2. Take an example or two to confirm your understanding of the input/output & extend it to test cases
Milestone 2: Finalize approach & execution plan
1. Understand what type of problem you are solving.
     a. Obvious logic, tests ability to convert logic to code
     b. Figuring out logic
     c. Knowledge of specific domain or concepts
     d. Knowledge of specific algorithm
     e. Mapping real world into abstract concepts/data structures
2. Brainstorm multiple ways to solve the problem and pick one
3. Get to a point where you can explain your approach to a 10 year old
4. Take a stab at the high-level logic & write it down.
5. Try to offload processing to functions & keeping your main code small.
Milestone 3: Code by expanding your pseudocode
1. Make sure you name the variables, functions clearly.
2. Avoid constants in your code unless necessary; go for generic functions, you can use examples for your thinking though.
3. Use libraries as much as possible
Milestone 4: Prove to the interviewer that your code works with unit tests
1. Make sure you check boundary conditions
2. Time & storage complexity
3. Suggest optimizations if applicable
*/
