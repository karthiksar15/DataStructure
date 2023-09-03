package practice.graph;

public class NoOfProvinces {
    int parent[];
    int rank[];

    public NoOfProvinces(int[][] mat) {
        parent = new int[mat.length];
        rank = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < mat.length; i++) {
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent != yParent) {
            if (rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent;
                rank[xParent] += 1;
                rank[yParent]--;
            } else if (rank[yParent] > rank[xParent]) {
                parent[xParent] = yParent;
                rank[yParent] += 1;
                rank[xParent]--;
            } else {
                parent[yParent] = xParent;
                rank[xParent] += 1;
                rank[yParent]--;
            }
        }

    }

    public int getNumberOfGrps(int[][] isConnected) {
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] > 0)
                    union(i, j);
            }
        }
        int count = 0;
        for (int i = 0; i < rank.length; i++) {
            if (rank[i] > 0)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
//        int[][] mat={{1,1,0},{1,1,0},{0,0,1}};
        int[][] mat = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        NoOfProvinces nop = new NoOfProvinces(mat);
        int count = nop.getNumberOfGrps(mat);
        System.out.println(count);

    }
}
