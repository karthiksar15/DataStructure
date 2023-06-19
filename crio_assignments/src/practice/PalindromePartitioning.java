package practice;

import java.util.*;

public class PalindromePartitioning {
    ArrayList<ArrayList<String> > palindromePartitioning(String s) {
        int n = s.length();

        // To Store all palindromic partitions
        ArrayList<ArrayList<String>> allPart = new ArrayList<>();

        // To store current palindromic partition
        Deque<String> currPart = new LinkedList<String>();

        // Call recursive function to generate
        // all partitions and store in allPart
        allPalPartitonsUtil(allPart, currPart, 0, n, s);
        return allPart;
    }
    private static void allPalPartitonsUtil(ArrayList<ArrayList<String>> allPart,
                                            Deque<String> currPart, int start, int n, String input)
    {
        // If 'start' has reached len
        if (start >= n)
        {
            allPart.add(new ArrayList<>(currPart));
            return;
        }

        // Pick all possible ending points for substrings
        for (int i = start; i < n; i++)
        {

            // If substring str[start..i] is palindrome
            if (isPalindrome(input, start, i))
            {

                // Add the substring to result
                currPart.addLast(input.substring(start, i + 1));

                // Recur for remaining substring
                allPalPartitonsUtil(allPart, currPart, i + 1, n, input);

                // Remove substring str[start..i] from current
                // partition
                currPart.removeLast();
            }
        }
    }

    // A utility function to check
    // if input is Palindrome
    private static boolean isPalindrome(String input,
                                        int start, int i)
    {
        while (start < i)
        {
            if (input.charAt(start++) != input.charAt(i--))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        ArrayList<ArrayList<String> > result = new PalindromePartitioning().palindromePartitioning(s);
        for(int i = 0 ; i < result.size() ; i++) {
            for(int j = 0 ; j < result.get(i).size() ; j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
        scanner.close();
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
