package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsAllPaths_v1 {

    public List<List<Integer>> allPaths(int[][] edges) {
        List<List<Integer>> results = new ArrayList<>();
        List<List<Integer>> graphs = new ArrayList<>();
        int size = edges.length - 1;
        for (int i = 0; i < size; i++) {
            graphs.add(new ArrayList<Integer>());
        }
        int index = 0;
        for (int[] edge : edges) {
            for (int v : edge) {
                graphs.get(index).add(v);
            }
            index++;
        }
        int src=0;
        int dest=size;

        for (int i = 0; i <size ; i++) {
            Stack<Integer> st=new Stack<>();
            List<Integer> temp=new ArrayList<>();
            temp.add(src);

            while(!st.isEmpty())
            {
                int vert=st.pop();
                temp.add(vert);
                if(vert==dest)
                {
                    results.add(temp);
                }
                for(Integer adj:graphs.get(vert))
                {
                    st.add(adj);
                }
            }


        }

        return results;
    }

    public static void main(String[] args) {
        DfsAllPaths_v1 dfs = new DfsAllPaths_v1();
//        [[4,3,1],[3,2,4],[3],[4],[]]
        int[][] edges = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(dfs.allPaths(edges));


    }
}
