package practice.LinkedList;

import java.util.Scanner;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

public class CopyOfLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Node head = null;
        Node top_1 = null;
        for (int i = 0; i < len; i++) {
            Node list = new Node();
            if (head == null) {
                head = list;
                top_1 = head;
            } else {
                head.next = list;
                head = head.next;
            }
        }

        Node newHead = copyRandomList(top_1);
        Node temp = newHead;
        do {
            System.out.println(temp.val);
            temp = temp.next;
        } while (temp != null);
    }

    public static Node copyRandomList(Node head) {
        Node current = head;
        Node new_node = null;
        Node new_node_head = null;

        while (current != null) {
            Node temp = new Node(current.val, current.next, null);
            // temp.next=current.next;
            current.next = temp;
            current = current.next.next;
        }
        current = head;
        int num = 0;
        while (current != null) {
            current.next.random = current.random.next;
            current = current.next.next;
        }
        current = head;
        //  System.out.println("head----"+current.val);
        // System.out.println("head next----"+current.next.val);
        while (current != null) {
            if (new_node == null) {
                Node temp = current.next;
                // System.out.println(temp.val);
                new_node = temp;
                //new_node.next=new_node.next.next;
                // new_node_head=new_node;

            } else {
                new_node.next = current.next;
                if (new_node_head == null)
                    new_node_head = new_node;
                new_node = new_node.next;
                // System.out.println(new_node.val);
                // new_node.next=current.next.next;
            }
            if (current.next != null)
                current = current.next.next;
        }
        //   System.out.println("head----"+new_node_head.random.val);
        // System.out.println("head next----"+new_node_head.next.random.val);
        return new_node_head;

    }

}


//    Problem Description
//    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//        Return a deep copy of the list i.e. the head of the copied linked list.
//
//        The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
//
//        For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
//
//        The original list should be restored if modified.
//
//        Input format:
//        Next line contains X space separated integers, elements of the linked list.
//
//        Next line contains X space separated integers, random pointers of each node in the linked list.
//
//        Output format
//        Return a deep copy of the list i.e. the head of the copied linked list.
//
//        Sample Input 1
//        10 20
//
//        2 2
//
//        Sample Output 1
//        10 20
//
//        20 20
//
//        Explanation 1
//        ========================
//
//        View of the Linked list
//
//        ========================
//
//        {10.next} -> {20}
//
//        and
//
//        {20.next} -> {null}
//
//        {10.random} -> {20}
//
//        and
//
//        {20.random} -> {20}
//
//        Constraints
//        3 <= K <= N <= 105
//
//        |A[i]| <= 109
//
//        Resources