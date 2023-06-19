package practice;

import java.io.*;
import java.util.*;

class FindPersonWithHeightH {

    // Complete the function implementation below
    public int findPersonWithHeightH(int[] nums, int target) {
        int pivot = 0, low = 0, high = nums.length - 1, result = -1;

        if (nums.length == 1 && nums[0] == target)
            return 0;
        else if (nums.length == 1 && nums[0] != target)
            return result;

        if (nums.length > 1)
            pivot = findPivot(nums);
        // System.out.println("pivot---"+pivot);

        if (pivot != -1) {
            if (target >= nums[low] && target <= nums[pivot]) {
                high = pivot;
                return Arrays.binarySearch(nums, low, high + 1, target);
            } else if (target >= nums[pivot + 1] && target <= nums[high]) {
                low = pivot + 1;
                return Arrays.binarySearch(nums, low, high + 1, target);
            }
        } else {
            result = Arrays.binarySearch(nums, low, high + 1, target);
            if (result >= 0)
                return result;

        }
        // while(low<=high)
        // {
        //     int mid=(low+(high-low)/2);
        //     if(nums[mid]==target)
        //      return mid;
        //     else if(target>nums[mid])
        //       low=mid+1;
        //     else
        //       high=mid-1;
        // }

        return result;
    }

    public int findPivot(int[] nums) {
        int pivot = -1;
        int low = 0, high = nums.length - 1;

        //   if (high < low)
        //     return -1;
        // if (high == low)
        //     return high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < high && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (low < mid && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            //  if(nums[high]>nums[mid])
        }

        return pivot;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seq[] = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while (q > 0) {
            int H = scanner.nextInt();
            int result = new FindPersonWithHeightH().findPersonWithHeightH(seq, H);
            System.out.println(result);
            q--;
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
