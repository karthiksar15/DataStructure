package practice.LinkedList;

import java.util.Scanner;

public class DeleteANodeFromList {
    public static void deleteGivenNode(ListNode node) {
        ListNode temp = node.next;
        node.next = temp.next;
        node.val = temp.val;
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
        int cnt = 1;

        do {
            if (cnt == new_val)
                deleteGivenNode(top);
            System.out.println(top.val);
            top = top.next;
            cnt++;
        } while (top != null);
    }
}
