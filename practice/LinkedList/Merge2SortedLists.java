package practice.LinkedList;

import java.util.Scanner;

public class Merge2SortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode result_head = null;
        ListNode temp = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (result == null) {
                result = temp;
                result_head = temp;
            } else {
                result.next = temp;
                result = result.next;
            }
        }
        if (l1 == null) {
            while (l2 != null) {
                temp = new ListNode(l2.val);
                l2 = l2.next;
                result.next = temp;
                result = result.next;
            }
        } else {
            while (l1 != null) {
                temp = new ListNode(l1.val);
                l1 = l1.next;
                result.next = temp;
                result = result.next;
            }
        }
        return result_head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        ListNode head = null;
        ListNode top_1 = null;
        for (int i = 0; i < len; i++) {
            ListNode list = new ListNode(sc.nextInt());
            if (head == null) {
                head = list;
                top_1 = head;
            } else {
                head.next = list;
                head = head.next;
            }
        }
        int new_val = sc.nextInt();
        head = null;
        ListNode top_2 = null;
        for (int i = 0; i < len; i++) {
            ListNode list = new ListNode(sc.nextInt());
            if (head == null) {
                head = list;
                top_2 = head;
            } else {
                head.next = list;
                head = head.next;
            }
        }
        ListNode newHead = mergeTwoLists(top_1, top_2);
        ListNode temp = newHead;
        do {
            System.out.println(temp.val);
            temp = temp.next;
        } while (temp != null);
    }
}


//    Problem Description
//Given 2 sorted linked lists, merge them into a new sorted linked list and return head of the merged list. The new list should be made by splicing (adjusting the pointers) together the nodes of the first two lists.
//
//        Input format
//        N - An integer denoting the number of nodes in the linked list.
//
//        N integers follow where ith integer denotes the ith node value in the linked list
//
//        M - An integer denoting the number of nodes in the linked list.
//
//        M integers follow where jth integer denotes the jth node value in the linked list
//
//        Output format
//        Return the sorted list after splicing the nodes of the first two lists.
//
//        Constraints
//        0 <= N <= 10^5
//
//        -10^9 <= value <= 10^9
//
//        0 <= M <= 10^5
//
//        -10^9 <= value <= 10^9
//
//        Sample Input 1
//        3
//
//        1 2 4
//
//        3
//
//        1 3 4
//
//        Sample Output 1
//        1 1 2 3 4 4
//
//        Explanation 1
//        Merging the input lists and keeping the new list sorted results in this.
//
//        Sample Input 2
//        4
//
//        1 5 7 6
//
//        1
//
//        3
//
//        Sample Output 2
//        1 3 5 7 6
//
//        Explanation 2
//        Merging the input lists and keeping the new list sorted results in this.