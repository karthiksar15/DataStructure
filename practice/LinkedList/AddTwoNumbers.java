package practice.LinkedList;

import java.util.Stack;

public class AddTwoNumbers {
    public static ListNode sumLists1(ListNode head1, ListNode head2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        ListNode current_1 = head1;
        ListNode current_2 = head2;
        ListNode new_node = null;
        ListNode new_node_head = null;
        if (head1 == null && head2 != null) {
            return head2;
        }
        if (head1 != null && head2 == null) {
            return head1;
        }
        if (head1 == null && head2 == null) {
            return null;
        }
        while (current_1 != null) {
            s1.push(current_1.val);
            current_1 = current_1.next;
        }
        while (current_2 != null) {
            s2.push(current_2.val);
            current_2 = current_2.next;
        }
        int carry = 0;
        int sum = 0;
        int rem = 0;
        int tot_size = Math.max(s1.size(), s2.size());
        for (int i = 0; i < tot_size; i++) {
            // System.out.println("s1 size---"+s1.size());
            // System.out.println("s2 size---"+s2.size());
            Integer num1 = 0;
            Integer num2 = 0;
            if (s1.size() > 0)
                num1 = s1.pop();
            if (s2.size() > 0)
                num2 = s2.pop();
            sum = num1 + num2 + carry;
            rem = sum % 10;
            ListNode temp = new ListNode(rem);
            // System.out.println(temp.val);
            if (new_node == null) {
                new_node = temp;
            } else {
                temp.next = new_node;
                new_node = temp;
            }
            // System.out.println(new_node.val);
            carry = sum / 10;

        }
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            temp.next = new_node;
            new_node = temp;
        }
        return new_node;
    }
}

//    Problem Description
//You’re given two numbers represented by two linked lists, where each node contains a single digit. The digits are stored in forward order i.e the one’s digit is at the tail of the list. Write a function that adds the two numbers and returns the sum as a linked list in the same order.
//
//        Input format
//        There are 4 lines of input.
//
//        First line contains N, the size of the first list
//
//        Next line contains N space separated integers
//
//        Third line contains M, the size of the second list
//
//        Next line contains M space separated integers
//
//        Output format
//        Return the resultant list after adding given lists.
//
//        Function definition
//        The given function accepts two arguments - representing the heads of the two lists,and returns the new head.
//
//        Constraints
//        1 <= N <= 1e5
//
//        1 <= M <= 1e5
//
//        0 <= value <= 9
//
//        Sample Input 1
//        3
//
//        6 1 7
//
//        3
//
//        2 9 5
//
//        Sample Output 1
//        9 1 2
//
//        Explanation 1
//        617 + 295 = 912.
//
//        Sample Input 2
//        2
//
//        4 9
//
//        1
//
//        5
//
//        Sample Output 2
//        5 4
//
//        Explanation 2
//        49 + 5 = 54.
//
//        Resource
//        Add two numbers represented by linked lists