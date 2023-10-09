package practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class kahns_algo {

    public int[] findOrder(int numCourses,int [][] prerequisites)
    {
           var graph =new ArrayList<ArrayList<Integer>>();
           for (int i=0;i<numCourses;i++)
           {
               graph.add(new ArrayList<Integer>());
           }
           int[] indegree=new int[numCourses];
           for(var p:prerequisites)
           {
               int from=p[1];
               int to=p[0];
               graph.get(from).add(to);
               ++indegree[to];
           }
        Queue<Integer> zeroDegree=new LinkedList<>();
           for(int i=0;i<indegree.length;i++)
           {
               if(indegree[i]==0)
               {
                   zeroDegree.add(i);
               }
           }
           int[] result=new int[numCourses];
           int index=0;
           while(!zeroDegree.isEmpty())
           {
               int course=zeroDegree.poll();
               result[index]=course;
               index++;
               for(var child:graph.get(course))
               {
                   --indegree[course];
                   if(indegree[course]==0)
                    zeroDegree.add(child);

               }
           }
           for(int in:indegree)
           {
               if(in!=0)
                   return new int[0];
           }
           return result;
    }
}
