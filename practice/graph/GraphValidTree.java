package practice.graph;

public class GraphValidTree {
    public static void main(String[] args) {
        int n = 5;
//        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        UnionFind uf = new UnionFind(n);
        boolean check = true;
        for (int i = 0; i < edges.length; i++) {

            check = uf.union(edges[i][0], edges[i][1]);
            if (!check) {
                System.out.println("False");
                break;
            }

        }
        if (check)
            System.out.println("True");
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < rank.length; i++) {
            rank[i] = 1;
        }
    }

    public int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public boolean union(int node1, int node2) {
        if (node1 == node2)
            return false;

        int x = find(node1);
        int y = find(node2);
        if (x == y)
            return false;
        if (rank[x] < rank[y]) {
            parent[y] = x;
            rank[x] += 1;
        } else {
            parent[x] = y;
            rank[y] += 1;
        }
        return true;


    }

}
