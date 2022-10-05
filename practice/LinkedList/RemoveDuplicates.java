package practice.LinkedList;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveDuplicates {

    public static void removeDuplicates(ListNode head) {
        Set<Integer> st = new HashSet<>();
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            if (!st.add(temp.val)) {
                prev.next = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
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
        removeDuplicates(top);
        while (top != null) {
            System.out.println(top.val);
            top = top.next;
        }

    }

}

//    Problem Description
//    Given a linked list(need not be sorted) with duplicates, remove all duplicates, such that only the first occurrence of each element must remain in the LL, and return the head.
//
//        Input format
//        There are 2 lines of input
//
//        First-line contains N, the number of elements in the linked list.
//
//        The next line contains N space-separated integers, elements of the linked list.
//
//        Output format
//        Print the linked list after removing duplicates. Only the first occurrence of an element should be present in the list.
//
//        Function definition
//        The function you have to complete accepts the head as an argument. You will make the necessary changes, and return the head.
//
//        Sample Input 1
//        5
//
//        1 2 2 3 3
//
//        Sample Output 1
//        1 2 3
//
//        Explanation 1
//        Node 2 and 3 have 2 occurrences each.
//
//        Sample Input 2
//        5
//
//        3 1 3 1 4
//
//        Sample Output 2
//        3 1 4
//
//        Explanation 1
//        The first occurrence of nodes 3 and 1 remains in the list and 4 has no duplicates.
//
//        Constraints
//        0 <= Number of nodes <= 105
//
//        -109 <= ListNode.val <= 109
//
//        Resource
//        Remove duplicates from an unsorted linked list