package practice.graph;

import java.util.*;

public class SmallStringWithSwaps {
    public static void main(String[] args) {
        SmallStringWithSwaps ss = new SmallStringWithSwaps();
//        String s = "dcab";
        String s = "cba";

        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(List.of(0, 1));
        pairs.add(List.of(1, 2));
//        pairs.add(List.of(0, 3));
//        pairs.add(List.of(1, 2));
//        pairs.add(List.of(0, 2));
        System.out.println(ss.smallestString(s, pairs));
    }

    public String smallestString(String s, List<List<Integer>> pairs) {
        UnionFind_3 uf = new UnionFind_3(s.length());
        for (List<Integer> e : pairs) {
            int src = e.get(0);
            int dest = e.get(1);
            uf.union(src, dest);
        }
        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        for (int vertex = 0; vertex < s.length(); vertex++) {
            int root = uf.find(vertex);
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(vertex);
        }
        char[] smallestString = new char[s.length()];
        for (List<Integer> indices : rootToComponent.values()) {
            List<Character> characters = new ArrayList<>();
            for (int index : indices) {
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);
            for (int index = 0; index < indices.size(); index++) {
                smallestString[indices.get(index)] = characters.get(index);
            }
        }
        return new String(smallestString);
    }

}

class UnionFind_3 {
    private int[] root;
    private int[] rank;

    public UnionFind_3(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
        }
    }
}

