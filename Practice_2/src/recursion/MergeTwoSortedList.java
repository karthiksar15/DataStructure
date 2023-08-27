package recursion;

class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int val) {
        this.val = val;
    }
}

public class MergeTwoSortedList {

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {

        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        l1.next=l2;
        ListNode l3=new ListNode(4);
        l2.next=l3;
        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(3);
        l4.next=l5;
        ListNode l6=new ListNode(4);
        l5.next=l6;

        MergeTwoSortedList m=new MergeTwoSortedList();
        m.merge(l1,l4);


    }
}
