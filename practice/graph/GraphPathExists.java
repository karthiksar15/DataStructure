package practice.graph;

import java.util.*;

public class GraphPathExists {

    public static void main(String[] args) {
        int n = 3, src = 0, destination = 2;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(new GraphPathExists().validPath(n, edges, src, destination));

    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] edge : edges) {
            mp.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            mp.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Stack<Integer> st = new Stack<>();
        st.push(source);
        while (!st.isEmpty()) {
            Integer num = st.pop();
            if (num == destination) {
                return true;
            }
            for (Integer edge : mp.get(num)) {
                if (!seen[edge]) {
                    seen[edge] = true;
                    st.push(edge);
                }

            }
        }

        return false;
    }


}
