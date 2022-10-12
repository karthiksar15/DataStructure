package practice.LinkedList;

public class RemoveCycle {
    public boolean detectAndRemoveCycle(ListNode head) {
        ListNode slow_p = head;
        ListNode slow_prev = head;
        ListNode fast_p = head;
        int flag = 0;
        if (linkedListCycle(head)) {

            while (slow_p != null && fast_p != null
                    && fast_p.next != null) {
                slow_prev = slow_p;

                slow_p = slow_p.next;
                System.out.println(slow_p.val);
                fast_p = fast_p.next.next;
                if (slow_p == fast_p) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                slow_prev.next = null;
                return true;
            }


        }

        return false;
    }

    public boolean linkedListCycle(ListNode head) {
        ListNode slow_p = head;
        ListNode fast_p = head;
        int flag = 0;
        while (slow_p != null && fast_p != null
                && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            return true;

        return false;
    }
}


//    Problem Description
//    Given only the head of a linked list, check whether the linked list contains cycle or not. If the linked list does not contain a cycle return false, otherwise remove the cycle and return true.
//
//        Input format
//        First line contains an integer N - Number of nodes in the linked list.
//
//        Second line contains N integers representing the linked list.
//
//        Third line contains one integer K - The index to which the tail connects to (-1 in case of no cycle).
//
//        Output format
//        Return true or false depending on whether the linked list contains cycle or not. If the answer is true modify the linked list and remove the cycle.
//
//        Sample Input 1
//        5
//
//        1 2 3 4 5
//
//        2
//
//        Sample Output 1
//        true
//
//        1 2 3 4 5
//
//        Explanation
//        Visualization:
//
//        image
//
//        After removing cycle: 1-->2-->3-->4-->5-->NULL
//
//        Sample Input 2
//        4
//
//        2 3 4 2
//
//        -1
//
//        Sample Output 2
//        false
//
//        Explanation
//        Visualization: 2-->3-->4-->2-->NULL
//
//        Constraints
//        1 <= N <= 10^5
//
//        -10^9 <= Value of node <= 10^9
//
//        -1 <= K <= N-1
//
//        Resources
//        Detect and Remove Loop