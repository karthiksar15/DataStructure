package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dfssrctodest {

    public boolean find(int n,int[][] edges,int source,int destination)
    {
        if(n==1)
            return true;
      boolean found=false;
      List<List<Integer>> adj=new ArrayList<>();
      boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
          for(int[] edge:edges)
          {
              adj.get(edge[0]).add(edge[1]);
              adj.get(edge[1]).add(edge[0]);
          }
        Stack<Integer> st=new Stack<>();
          st.add(source);
          visited[source]=true;
          while (!st.isEmpty())
          {
              Integer num=st.pop();

              for(Integer lst:adj.get(num))
              {
                  if(lst==destination)
                  {
                      found=true;
                      st.clear();
                      break;
                  }
                  else if(!visited[lst])
                  {
                      st.push(lst);
                      visited[lst]=true;
                  }

              }
          }



      return  found;
    }
    public static void main(String args[])
    {
        Dfssrctodest dfs=new Dfssrctodest();
        int n=6;
        int[][] edges={{0,1},{0,2},{3,5},{5,4},{4,3}};
        int src=0;
        int destination=5;
        System.out.println(dfs.find(n,edges,src,destination));
    }
}
