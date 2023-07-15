package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsFindIfPathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination)
    {
        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        q.add(source);
        visited[source]=true;

        while (!q.isEmpty())
        {
            Integer vertices=q.poll();
            if (vertices==destination)
                return true;
            for(Integer vertex:adj.get(vertices))
            {
                if (!visited[vertex])
                {
                    q.add(vertex);
                    visited[vertex]=true;
                }

            }
        }
        return false;
    }
    public static void main(String[] args) {
        BfsFindIfPathExists bfs=new BfsFindIfPathExists();
        int n=6;
//        int[][] edges={{0,1},{0,2},{3,5},{5,4},{4,3}};
        int[][] edges={{0,1},{1,2},{2,0}};
        System.out.println(bfs.validPath(3,edges,0,2));

    }
}
