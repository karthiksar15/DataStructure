package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsFullPath_v2 {
    public List<List<Integer>> fullPath(int[][] edges)
    {
        List<List<Integer>> results=new ArrayList<>();
        List<List<Integer>> adjLst=new ArrayList<>();
        int src=0;
        int dest=edges.length-1;
        for (int i = 0; i <=dest ; i++) {
            adjLst.add(new ArrayList());
        }
        int index=0;
        for (int[] edge:edges) {
            for (int i=0;i<edge.length;i++)
            {
                adjLst.get(index).add(edge[i]);
            }
            index++;
        }
        Stack<List> st=new Stack<>();
        st.push(new ArrayList(List.of(src)));

        while(!st.isEmpty())
        {
            List<Integer> temp=st.pop();
            int current=temp.get(temp.size()-1);
            if(current==dest)
            {
                results.add(temp);
            }else
            {
                for (Integer adj: adjLst.get(current)) {
                    List<Integer>  newPath=new ArrayList<>(temp);
                    newPath.add(adj);
                    st.push(newPath);
                }
            }
        }
        return results;
    }
    public static void main(String[] args) {
        DfsFullPath_v2 dfs=new DfsFullPath_v2();
        int[][] edges = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(dfs.fullPath(edges));

    }
}
