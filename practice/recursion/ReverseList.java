package practice.recursion;


class Nodes
{
    public int val;
    public Nodes next;

    public Nodes(int val)
    {
        this.val=val;
    }
}
public class ReverseList {

    private static Nodes root;

    public static void main(String[] args) {
        ReverseList rl=new ReverseList();
        Nodes node=new Nodes(1);
        Nodes node1=new Nodes(2);
        node.next=node1;
        Nodes node2=new Nodes(3);
        node1.next=node2;
        Nodes node3=new Nodes(4);
        node2.next=node3;
        Nodes node4=new Nodes(5);
        node3.next=node4;
        Nodes result=rl.reverseList(node);
        while(result!=null)
        {
            System.out.println(result.val);
            result=result.next;
        }

    }

    public Nodes reverseList(Nodes head)
    {
         if( head==null ||head.next==null)
         {
             return head;
         }
         Nodes nodes=reverseList(head.next);
         head.next.next=head;
         head.next=null;
         return nodes;
    }
}
