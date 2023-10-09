package practice.graph;

import java.util.Arrays;

public class EarliestMoment {
    public static void main(String[] args) {
//        int n = 6;
        int n=4;
        int[][] nums={{9,3,0},{0,2,1},{8,0,1},{1,3,2},{2,2,0},{3,3,1}};
        // Compare values according to columns
        Arrays.sort(nums, (entry1, entry2) -> {

            // To sort in descending order revert
            // the '>' Operator
            if (entry1[0] > entry2[0])
                return 1;
            else
                return -1;
        });
//        sort the timestamp
//        int[][] nums = {{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}};
        UnionFind_2 uf = new UnionFind_2(n);
        for (int[] num : nums) {
            if(uf.union(num[1], num[2]))
            {
                System.out.print(num[0]);
                break;
            }
        }


    }
}

class UnionFind_2 {
    private int[] rank;
    private int[] parent;
    private int count;

    public int[] getRank() {
        return rank;
    }

    public UnionFind_2(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            parent[i] = -1;
            this.count = n ;
        }
    }

    public int find(int node) {
        if (parent[node] == -1)
            return -1;
        else if (node == parent[node])
            return node;
        return parent[node] = find(parent[node]);
    }

    public boolean union(int node1, int node2) {
        int x = find(node1);
        int y = find(node2);
        boolean flag=false;
        if (x == -1 && y==-1) {
            x = node1;
            y = node2;
        }
        if (x != y) {
            if (y > x) {
                if(x==-1)
                    x=node1;
                parent[x] = y;
                parent[y] = y;
                rank[y] += rank[x];
                if(rank[y]==count)
                    flag=true;
            } else {
                if(y==-1)
                    y=node2;
                parent[y] = x;
                parent[x] = x;
                rank[x] += rank[y];
                if(rank[x]==count)
                    flag=true;
            }
        }
        return flag;
    }

}