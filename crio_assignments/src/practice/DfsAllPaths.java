package practice;

import java.util.*;

public class DfsAllPaths {

    public List<List<Integer>> allPaths(int[][] edges) {

        List<List<Integer>> graphs = new ArrayList<>();
        int size = edges.length - 1;
        for (int i = 0; i <= size; i++) {
            graphs.add(new ArrayList<Integer>());
        }
        int index = 0;
        for (int[] edge : edges) {
            for (int v : edge) {
                graphs.get(index).add(v);
            }
            index++;
        }
        int source=0;
        int destination=size;
        List<List<Integer>> paths = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(new ArrayList<>(List.of(source)));

        while (!stack.isEmpty()) {
            List<Integer> path = stack.pop();
            int current = path.get(path.size() - 1);

            if (current == destination) {
                paths.add(path);
            } else {
                for (int neighbor : graphs.get(current)) {
                    if (!path.contains(neighbor)) {
                        List<Integer> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        stack.push(newPath);
                    }
                }
            }
        }

        return paths;
    }

    public static void main(String[] args) {
        DfsAllPaths dfs = new DfsAllPaths();
//        [[4,3,1],[3,2,4],[3],[4],[]]
        int[][] edges = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(dfs.allPaths(edges));


    }
}
