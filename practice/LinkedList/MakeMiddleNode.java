package practice.LinkedList;


import java.util.Scanner;

public class MakeMiddleNode {
    public static void makeMiddleNode(ListNode head) {
        ListNode prev = null;
        ListNode one = head;
        ListNode two = head;
        while (two != null && two.next != null) {
            prev = one;
            one = one.next;
            two = two.next.next;
        }
        prev.next = one.next;
        one.next = head;
        while (one != null) {
            System.out.println(one.val);
            one = one.next;
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
        makeMiddleNode(top);
    }
}

//    Problem Description
//    Given a singly linked list, find the middle node of the linked list and move that node to the head of the list. Return the head of the list. In the case of a list with an even number of nodes, use the second middle one.
//
//        Input format
//        There are 2 lines of input
//
//        N - An integer denoting the number of nodes in the linked list.
//
//        N integers follow where ith integer denotes the ith node value in the linked list
//
//        Output format
//        Return the head of the modified list after moving the middle node to head.
//
//        Constraints
//        0 <= N<= 10^5
//
//        -10^9 <= value <= 10^9
//
//        Sample Input 1
//        6
//
//        2 3 4 5 6 7
//
//        Sample Output 1
//        5 2 3 4 6 7
//
//        Explanation 1
//        The middle node here is [5]. Moving that to the head of the list gives us the output shown.
//
//        Sample Input 2
//        5
//
//        1 2 3 4 5
//
//        Sample Output 2
//        3 1 2 4 5
//
//        Explanation 2
//        The middle node here is [3]. Moving that to the head of the list gives us the output shown.
//
//        Resource
//        Make middle node head in a linked list