package practice;

import java.util.*;


class SubsetSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, t;
        n = sc.nextInt();
        t = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (subsetSum(arr, t)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static boolean subsetSum(int a[], int sum) {
        boolean result = false;
        if (subsetSumUtil(a, a.length, sum) == 1) {
            return true;
        }
        return result;
    }

    static int subsetSumUtil(int a[], int n, int sum) {
        int tab[][] = new int[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                tab[i][j] = -1;
            }
        }

        // If the sum is zero it means
        // we got our expected sum
        if (sum == 0)
            return 1;

        if (n <= 0)
            return 0;

        // If the value is not -1 it means it
        // already call the function
        // with the same value.
        // it will save our from the repetition.
        if (tab[n - 1][sum] != -1)
            return tab[n - 1][sum];

        // if the value of a[n-1] is
        // greater than the sum.
        // we call for the next value
        if (a[n - 1] > sum)
            return tab[n - 1][sum]
                    = subsetSumUtil(a, n - 1, sum);
        else {

            // Here we do two calls because we
            // don't know which value is
            // full-fill our criteria
            // that's why we doing two calls
            if (subsetSumUtil(a, n - 1, sum) != 0
                    || subsetSumUtil(a, n - 1, sum - a[n - 1])
                    != 0) {
                return tab[n - 1][sum] = 1;
            } else
                return tab[n - 1][sum] = 0;
        }

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
