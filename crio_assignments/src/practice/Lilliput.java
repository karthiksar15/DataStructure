package practice;

import java.util.*;

class SegmentTree {

    int st[]; // The array that stores segment tree nodes

    /* Constructor to construct segment tree from given array. This
       constructor  allocates memory for segment tree and calls
       constructSTUtil() to  fill the allocated memory */
    SegmentTree(int arr[], int n) {
        // Allocate memory for segment tree
        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;

        st = new int[max_size]; // Memory allocation

        constructSTUtil(arr, 0, n - 1, 0);
    }

    // A utility function to get the middle index from corner indexes.
    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    int constructSTUtil(int arr[], int ss, int se, int si) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(ss, se);
        st[si] = Math.min(constructSTUtil(arr, ss, mid, si * 2 + 1),
                constructSTUtil(arr, mid + 1, se, si * 2 + 2));
        return st[si];
    }

    int updateValueUtil(int ss, int se, int i, int diff, int si) {
        // Base Case: If the input index lies outside the range of
        // this segment

        if (ss == se)
            return st[si] = diff;
        int mid = getMid(ss, se);
        if (i >= ss && i <= mid) {
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
        } else {
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
        return st[si] = Math.min(st[2 * si + 1], st[2 * si + 2]);

    }
    // If the input index is in range of this node, then update the
    // value of the node and its children
//        st[si] = st[si] + diff;
//        if (se != ss) {
//            int mid = getMid(ss, se);
//            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
//            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
//        }


    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree


    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return st[si];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return Math.min(getSumUtil(ss, mid, qs, qe, 2 * si + 1),
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2));
    }

    int getSum(int n, int qs, int qe) {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }
}

public class Lilliput {
    // Implement Your solution Here


    public static Vector<Integer> lilliput(int n, int heights[], int num_actions, String actions[]) {
        SegmentTree st = new SegmentTree(heights, n);
        Vector<Integer> ans = new Vector<Integer>();
        for (int i = 0; i < num_actions; i++) {
            String[] str_arr = actions[i].split(" ");
            if (str_arr[0].equals("q")) {
                ans.add(st.getSum(n, Integer.parseInt(str_arr[1]), Integer.parseInt(str_arr[2])));
            } else {
                st.updateValueUtil(0, n - 1, Integer.parseInt(str_arr[1]), Integer.parseInt(str_arr[2]), 0);
            }
//            System.out.println(actions[i]);
        }
        return ans;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, q;

        n = sc.nextInt();
        int heights[] = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        q = sc.nextInt(); // Num actions
        sc.nextLine();

        String actions[] = new String[q];
        for (int i = 0; i < q; i++) {
            actions[i] = sc.nextLine();
        }
        sc.close();

        Vector<Integer> answer = lilliput(n, heights, q, actions);
        for (int i = 0; i < answer.size(); i++)
            System.out.println(answer.get(i));
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
