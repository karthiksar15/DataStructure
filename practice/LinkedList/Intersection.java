package practice.LinkedList;

public class Intersection {
    public static ListNode listIntersectionPoint(ListNode head1, ListNode head2) {
        int tot_diff = 0;
        int max_size = 0;
        int cur_1 = 0;
        int cur_2 = 0;
        ListNode current_1 = head1;
        ListNode current_2 = head2;
        while (current_1 != null) {
            cur_1 += 1;
            current_1 = current_1.next;
        }

        while (current_2 != null) {
            cur_2 += 1;
            current_2 = current_2.next;
        }
        if (cur_1 >= cur_2) {
            current_1 = head1;
            current_2 = head2;
        } else if (cur_2 > cur_1) {
            current_1 = head2;
            current_2 = head1;
        }

        tot_diff = Math.max(cur_1, cur_2) - Math.min(cur_1, cur_2);
        // System.out.println("tot_diff----"+tot_diff);
        max_size = Math.max(cur_1, cur_2);
        // System.out.println("max_size----"+max_size);
        int check = 0;
        for (int i = 0; i < max_size; i++) {
            if (current_1 == null && current_2 == null)
                return null;
            if (current_1 == current_2) {
                // System.out.println(current_1.val);
                return current_1;
            }
            if (check >= tot_diff) {
                current_2 = current_2.next;
            }
            current_1 = current_1.next;
            check++;
        }
        return null;
    }
}
