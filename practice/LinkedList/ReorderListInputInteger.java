package practice.LinkedList;

import java.util.Scanner;

public class ReorderListInputInteger {

    public static ListNode reorderListInputInteger(ListNode head, int x) {
        ListNode result = null;
        ListNode result_head = null;
        ListNode begin = null;
        ListNode begin_head = null;
        ListNode end = null;
        ListNode end_head = null;
        ListNode mid = null;
        ListNode mid_head = null;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                if (begin == null) {
                    begin = new ListNode(current.val);
                    begin_head = begin;
                } else {
                    begin.next = new ListNode(current.val);
                    begin = begin.next;
                }

            } else if (current.val == x) {
                if (mid == null) {
                    mid = new ListNode(current.val);
                    mid_head = mid;
                } else {
                    mid.next = new ListNode(current.val);
                    mid = mid.next;
                }
            } else {
                if (end == null) {
                    end = new ListNode(current.val);
                    end_head = end;
                } else {
                    end.next = new ListNode(current.val);
                    end = end.next;
                }

            }
            current = current.next;
        }
        while (begin_head != null) {
            // System.out.println("being---"+begin_head.val);
            if (result == null) {
                result = begin_head;
                result_head = result;
            } else {
                result.next = begin_head;
                result = result.next;
            }
            begin_head = begin_head.next;

        }
        while (mid_head != null) {
            // System.out.println("mid---"+mid_head.val);
            if (result == null) {
                result = mid_head;
                result_head = result;
            } else {
                result.next = mid_head;
                result = result.next;
            }
            mid_head = mid_head.next;
        }
        while (end_head != null) {
            // System.out.println("end---"+end_head.val);
            if (result == null) {
                result = end_head;
                result_head = result;
            } else {
                result.next = end_head;
                result = result.next;
            }
            end_head = end_head.next;
        }


        return result_head;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        ListNode head = null;
        ListNode top = null;
        for (int i = 0; i < len; i++) {
            ListNode list = new ListNode(sc.nextInt());
            if (head == null) {
                head = list;
                top = head;
            } else {
                head.next = list;
                head = head.next;
            }
        }
        int new_val = sc.nextInt();
        ListNode newHead = reorderListInputInteger(top, new_val);
        ListNode temp = newHead;
        do {
            System.out.println(temp.val);
            temp = temp.next;
        } while (temp != null);
    }
}

//    Problem Description
//    Given a linked list and an integer X, partition the LL around X, such that all nodes less than X come before all nodes greater than X. If X is contained within the list, then those nodes need
//
//        to be after the elements less than X and before the elements greater than X, i.e. they should appear between the left and right partitions.
//
//
//        You can also see if you can preserve the order for elements on either side of the partition. For instance, for given LL 2, 6, 5, 7, 1 and X = 5, the answer should be 2, 1, 5, 6, 7 only, instead of 1, 2, 5, 6, 7.
//
//        Input format
//        N - An integer denoting the number of nodes in the linked list.
//
//        N integers follow where ith integer denotes the ith node value in the linked list
//
//        X - An integer denoting the value that you must use to partition the given list
//
//        Output format
//        Return the head after partitioning the list
//
//        Constraints
//        1 <= N <= 10^5
//
//        -10^9 <= value, X <= 10^9
//
//        Sample Input 1
//        7
//
//        3 5 8 5 10 2 1
//
//        5
//
//        Sample Output 1
//        3 2 1 5 5 8 10
//
//        Explanation 1
//        The nodes [3], [1] and [2] are less than [5] so they are present before [8] and [10].
//
//        There are also other possible answers for the same input.
//
//        Sample Input 2
//        5
//
//        3 1 3 1 4
//
//        2
//
//        Sample Output 2
//        1 1 4 3 3
//
//        Explanation 2
//        All nodes with values less than 2 come before all nodes with values greater than 2.
//
//        Resource
//        Partitioning a linked list around a given value and keeping the original order