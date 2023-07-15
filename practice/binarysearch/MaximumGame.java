package practice.binarysearch;

import java.util.*;


class MaximumGame {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maximumGame(nums, n));
    }

    static int maximumGame(int[] nums, int n) {
        if (n == 1) return nums[0];

        //     for(int i=2; i<n; i++)
        //     {
        //         if(i==2)       nums[i] += nums[i-2];
        //         else if(i>=3)  nums[i] += Math.max(nums[i-2], nums[i-3]);

        //     }


        //     return Math.max(nums[n-1], nums[n-2]);
        // }
        int sum = 0, tot = 0, min = Integer.MAX_VALUE, mod = 100000007;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            //   tot=((tot%mod)+(nums[i]%mod))%mod;
            tot = tot + nums[i];
        }
        int low = min, high = tot, res = 0;
        while (low <= high) {
            int mid = (low + (high - low)) / 2;
            boolean chk_flag = check(nums, mid);
            if (chk_flag) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;

    }

    public static boolean check(int[] nums, int mid) {

        int mod = 100000007;
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {

            if (i == 2) sum += nums[i - 2];
            else if (i >= 3) sum += Math.max(nums[i - 2], nums[i - 3]);
            if (sum == mid)
                return true;
        }
        return false;
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
