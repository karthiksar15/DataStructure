package practice.recursion;


//  Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class SwapNodes {

    public static void main(String[] args) {
        ListNode node=new ListNode(10);
        ListNode node1=new ListNode(20);
        node.next=node1;
        ListNode node2=new ListNode(30);
        node1.next=node2;
        ListNode node3=new ListNode(40);
        node2.next=node3;
        ListNode node4=new ListNode(50);
        ListNode result= swapPairs(node);
        while(result!=null)
        {
            System.out.println(result.val);
            result=result.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
             if(head==null || head.next==null)
                 return head;

             ListNode firstNode=head;
             ListNode secondNode=head.next;

             firstNode.next=swapPairs(secondNode.next);
             secondNode.next=firstNode;

             return secondNode;
    }

}
