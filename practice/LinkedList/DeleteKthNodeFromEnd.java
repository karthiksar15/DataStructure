package practice.LinkedList;

import java.util.Scanner;

public class DeleteKthNodeFromEnd {
    public static ListNode deleteKthToLast(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        current = head;
        if (k == 0 || k > size)
            return head;
        int num = size - k;
        if (num == 0) {
            head = current.next;
        } else {
            int count = 0;
            while (current != null) {
                if (count == num) {
                    prev.next = current.next;
                    return head;
                }
                prev = current;
                current = current.next;
                count++;
            }
        }
        return head;
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
        ListNode newHead = deleteKthToLast(top, new_val);
        ListNode temp = newHead;
        do {
            System.out.println(temp.val);
            temp = temp.next;
        } while (temp != null);
    }
}
