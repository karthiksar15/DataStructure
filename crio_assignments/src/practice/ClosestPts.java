package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>
{
    int first, second;
    Pair(int a, int b)
    {
        this.first = a;
        this.second = b;
    }

    public int compareTo(Pair o)
    {
        System.out.println("inside---this.first--"+this.first);
        System.out.println("inside---this.second--"+this.second);
        System.out.println("inside---o.first--"+o.first);
        System.out.println("inside---o.second--"+o.second);
        int x1 = this.first * this.first;
        int y1 = this.second * this.second;
        int x2 = o.first * o.first;
        int y2 = o.second * o.second;
        System.out.println("inside compare (x1 + y1)--"+((x1 + y1)));
        System.out.println("inside compare (x2 + y2)--"+((x2 + y2)));
        return (x1 + y1) - (x2 + y2);
    }
}

public class ClosestPts {
  public static void main(String args[])
  {
//      PriorityQueue<Pair> pq=new PriorityQueue<>();
      List<Pair> list=new ArrayList<Pair>();
      list.add(new Pair(4,5));
      list.add(new Pair(1,2));
      list.add(new Pair(3,6));
      Collections.sort(list);
      for(Pair p:list)
      {
          System.out.println(p.first+".."+p.second);
      }



//      System.out.println(pp.toString());

  }
}
