package graph;

class Solution6 {
    public int countComponents(int n, int[][] edges) {
        int count = n;
        UnionFind_1 uf1 = new UnionFind_1(n);
        for (int i = 0; i < edges.length; i++) {
            count = count - uf1.union(edges[i][0], edges[i][1]);
        }
        return count;
    }
}
class UnionFind_1 {

    private int[] parent;
    private int[] rank;


    public UnionFind_1(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int i = 0; i < n; i++)
            rank[i] = 1;
    }

    public int find(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = find(parent[node]);
    }

    public int union(int node1, int node2) {
        int x = find(node1);
        int y = find(node2);
        if (x != y) {
            if (rank[y] > rank[x]) {
                parent[x] = y;
                rank[y] += 1;
            } else {
                parent[y] = x;
                rank[x] += 1;
            }
            return 1;
        } else {
            return 0;
        }

    }

}

public class NumberOfConnectedComponentsUndirectedGraph {
    public static void main(String[] args) {
        int n=5;
        int[][] edges={{0,1},{1,2},{2,3},{3,4}};
        Solution6 s=new Solution6();
        System.out.println(s.countComponents(n,edges));

    }


}
