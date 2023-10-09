package twoPointers;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

}

public class StockPriceChange {

    public ListNode stockPriceChange(ListNode head, int x) {
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
                    begin_head = new ListNode(current.val);
                    begin = begin_head;
                } else {
                    begin.next = new ListNode(current.val);
                    begin = begin.next;
                }
            } else if (current.val == x) {
                if (mid == null) {
                    mid_head = new ListNode(current.val);
                    mid = mid_head;
                } else {
                    mid.next = new ListNode(current.val);
                    mid = mid.next;
                }
            } else if (current.val > x) {
                if (end == null) {
                    end_head = new ListNode(current.val);
                    end = end_head;
                } else {
                    end.next = new ListNode(current.val);
                    end = end.next;
                }
            }
            current=current.next;
        }
        while (begin_head != null) {
            if (result == null) {
                result_head = begin_head;
                result = begin_head;

            } else {
                result.next = begin_head;
                result=result.next;
            }
            begin_head = begin_head.next;
        }
        while (mid_head != null) {
            if (result == null) {
                result_head = mid_head;
                result = mid_head;
            } else {
                result.next = mid_head;
                result = result.next;
            }
            mid_head = mid_head.next;
        }
        while (end_head != null) {
            if (result == null) {
                result_head = end_head;
                result = end_head;
            } else {
                result.next = end_head;
                result=result.next;
            }
            end_head = end_head.next;
        }
        return result_head;
    }

    public static void main(String[] args) {
        StockPriceChange sp = new StockPriceChange();
//        3 5 8 5 10 2 1
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(5);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(8);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(5);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(10);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(2);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(1);
        listNode5.next = listNode6;
        ListNode result= sp.stockPriceChange(listNode, 5);
        while (result!=null)
        {
            System.out.println(result.val);
            result=result.next;
        }

    }
}
