package practice.LinkedList;

import java.util.List;
import java.util.Scanner;

public class ReversingLinkedList {

    public static void reverseList(ListNode head) {
        ListNode temp = head;
        ListNode next;
        ListNode prev = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        while (prev != null) {
            System.out.println(prev.val);
            prev = prev.next;
        }
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
        reverseList(top);
    }
}


//    Problem Description
//    Given the elements of a linked list, reverse it.
//
//
//        You’ll have to implement the given method, which has the original list’s head pointer as an argument, and return the head of the updated list.
//
//        Input format
//        There are two lines of input.
//
//        First line contains N, the number of elements in the linked list.
//
//        Second line contains N space separated integers.
//
//        Output format
//        Only line contains N space separated integers
//
//        Sample Input 1
//        5
//
//        1 2 3 4 5
//
//        Sample Output 1
//        5 4 3 2 1
//
//        Explanation 1
//        1->2->3->4->5->NULL
//
//        5->4->3->2->1->NULL
//
//        Constraints
//        0 <= N <= 10^5
//
//        -10^9 <= A[i] <= 10^9
//
//        Resources
//        Reverse a linked list