package practice.LinkedList;

public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode result = null;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode middle = getMiddleNode(current);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode left = sortList(current);
        ListNode right = sortList(middleNext);
        result = sortList(left, right);
        return result;
    }

    public ListNode getMiddleNode(ListNode current) {
        ListNode slowPtr = current;
        ListNode fastPtr = current;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode sortList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        if (left == null)
            prev.next = right;
        else
            prev.next = left;

        return dummy.next;
    }
}


//    Problem Description
//    Given a singly linked list containing N integers, sort it in O(NlogN) time.
//
//        Input format
//        N - An integer denoting the number of nodes in the linked list.
//
//        N integers follow where ith integer denotes the ith node value in the linked list-
//
//        Output format
//        Return the head of the sorted list.
//
//        Function definition
//        You have to implement the given function. It accepts the head of the LL as an argument. You have to return the new head of the sorted list after sorting it
//
//        Constraints
//        1 <= N <= 10^5
//
//        -10^9 <= value <= 10^9
//
//        Sample Input 1
//        4
//
//        4 2 1 3
//
//        Sample Output 1
//        1 2 3 4
//
//        Explanation 1
//        This is the sorted output.
//
//        Sample Input 2
//        4
//
//        8 20 2 9
//
//        Sample Output 2
//        2 8 9 20
//
//        Explanation 2
//        This is the sorted output.
//
//        Pattern introduction video