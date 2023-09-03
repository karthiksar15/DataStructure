package practice.graph;

import java.util.*;

public class PathsSrcToTarget {

    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {3}, {3}, {}};
        System.out.println(new PathsSrcToTarget().allPathsSourceTarget(edges));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
           this.target=graph.length-1;
           this.graph=graph;
           this.results=new ArrayList<>();
           LinkedList<Integer> path=new LinkedList<>();
           path.add(0);
           backtrack(0,path);
           return this.results;
    }
    protected void backtrack(int currNode,LinkedList<Integer> path)
    {
             if(currNode==this.target)
             {
                 this.results.add(new ArrayList<>(path));
                 return;
             }
             for(int nextNode:this.graph[currNode])
             {
                 path.addLast(nextNode);
                 backtrack(nextNode,path);
                 path.removeLast();
             }
    }


}
