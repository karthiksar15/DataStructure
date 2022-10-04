package practice.stack;

import com.sun.source.tree.Tree;

import java.util.*;

class TreeNode {
    public Long val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(long x) {
        val = x;
        left = null;
        right = null;
    }

}

public class ZigZag {


    public List<List<Long>> zigzagLevelOrder(TreeNode root) {
        List<List<Long>> nodeLst = new ArrayList<List<Long>>();
        List<Long> eachNodeLst = new ArrayList<Long>();
        Stack<TreeNode> current = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        int rightToLeft = 1;
        current.push(root);
        while (current.size() > 0) {
            TreeNode temp = current.pop();
            if (temp != null) {
                eachNodeLst.add(temp.val);
                if (rightToLeft == 1) {
                    next.push(temp.left);
                    next.push(temp.right);
                } else {
                    next.push(temp.right);
                    next.push(temp.left);
                }
            }

            if (current.size() == 0) {
                rightToLeft = 1 - rightToLeft;
                // swap(current,next);
                Stack<TreeNode> temp1 = current;
                current = next;
                next = temp1;
                nodeLst.add(eachNodeLst);
                eachNodeLst = new ArrayList<Long>();
            }
        }

        return nodeLst;
    }

    public void swap(Stack<TreeNode> current, Stack<TreeNode> next) {
        Stack<TreeNode> temp1 = new Stack<TreeNode>();
        temp1 = current;
        current = next;
        next = temp1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        TreeNode head = null;
        while (t-- > 0) {
            int tot = sc.nextInt();
            int temp = tot;
            HashMap<Integer, TreeNode> mp = new HashMap<>();
            Integer index = 1;
            while (tot-- > 0) {
                Long val = sc.nextLong();
                mp.put(index, new TreeNode(val));
                index++;
            }
            tot = temp;
            while (tot-- > 0) {
                Integer pos = sc.nextInt();
                Integer left = sc.nextInt();
                Integer right = sc.nextInt();
                TreeNode node = mp.get(pos);
                if (left != -1)
                    node.left = mp.get(left);
                if (right != -1)
                    node.right = mp.get(right);
                if (pos == 1)
                    head = node;
            }
            ZigZag z = new ZigZag();
            List<List<Long>> res = z.zigzagLevelOrder(head);
            for (List<Long> list : res) {
                System.out.println(list);
            }


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


//    Problem Description
//    Given a binary tree, return the zigzag level order traversal of its nodes' values.
//
//        (i.e. from left to right, then right to left for the next level and alternate for every level).
//
//
//        For the tree given, zigzag traversal will be:
//
//        image
//
//        1
//
//        3 2
//
//        4 5
//
//        Input format
//        Line 1 has the number of test cases (T)
//
//        Line 2 to X: First Test Case details with the binary tree structure (refer section below for the format)
//
//        Line X+1 to Y: Second Test case details and so on.
//
//        Output format
//        For each test case, print K lines, where K is the height of the tree. In each line print the values of the zigzag traversed node values.
//
//        Constraints
//        1 <= T <= 1000
//
//        1 <= Number of nodes in a Tree <= 10000
//
//        0 <= Value of each node <= 10^9
//
//        It's guaranteed that the sum of the number of tree nodes across all test cases will be less than 500000.
//
//        Sample Input 1
//        1
//
//        5
//
//        5 1 4 3 6
//
//        1 2 3
//
//        2 -1 -1
//
//        3 4 5
//
//        4 -1 -1
//
//        5 -1 -1
//
//        Sample Output 1
//        5
//
//        4 1
//
//        3 6
//
//        Explanation 1
//        Treeview