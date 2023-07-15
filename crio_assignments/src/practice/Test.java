package practice;

import java.util.PriorityQueue;

public class Test {

    public void test(Edge edge)
    {
        Edge edge1=edge;
        while(edge1!=null)
        {
            
            edge1=null;
        }
        System.out.println(edge);
    }
    public static void main(String args[])
    {
//        PriorityQueue<Edge> pq=new PriorityQueue<>((x,y)->x.cost-y.cost);
//        pq.add(new Edge(1,2,10));
//        pq.add(new Edge(1,3,20));
//        pq.add(new Edge(1,4,30));
//        pq.add(new Edge(1,5,40));
//        pq.add(new Edge(2,3,20));
//        pq.add(new Edge(2,4,50));
//        pq.add(new Edge(2,5,60));
//        System.out.println(pq.poll().cost);
//        System.out.println(pq.poll().cost);
//        System.out.println(pq.poll().cost);
//        System.out.println(pq.poll().cost);
        Edge ed=new Edge(1,2,3);
        Test test=new Test();
        test.test(ed);
    }
}
class Edge
{
    int p1;
    int p2;
    int cost;
    public Edge(int p1,int p2,int cost)
    {
        this.p1=p1;
        this.p2=p2;
        this.cost=cost;
    }
}