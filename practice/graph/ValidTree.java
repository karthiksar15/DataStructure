package practice.graph;


class ValidTree {

    public static void main(String[] args) {
//        int[][] isConnected = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        int[][] isConnected = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        ValidTree prov = new ValidTree();
        System.out.println(prov.validTree(5, isConnected));

    }

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        UnionFind uf = new UnionFind(n);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (!uf.union(i, j)) {
//                    return false;
//                }
//            }
//        }
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!uf.union(A, B)) {
                return false;
            }
        }

        return true;
    }

    class UnionFind {
        int[] root;
        int[] rank;
        int count;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int A) {
//            if (root[x] == x)
//                return x;
//            return root[x] = find(root[x]);
            // Step 1: Find the root.
            int chk = A;
            while (root[chk] != chk) {
                chk = root[chk];
            }
            // Step 2: Do a second traversal, this time setting each node to point
            // directly at A as we go.
            while (A != chk) {
                int oldRoot = root[A];
                root[A] = chk;
                A = oldRoot;
            }
            return chk;
        }

        public boolean union(int rootX, int rootY) {
            int x = find(rootX);
            int y = find(rootY);
            if (x == y) {
                return false;
            }

            if (rank[x] < rank[y]) {
                root[y] = x;
                rank[x] += rank[y];
            } else {
                root[x] = y;
                rank[y] += rank[x];
            }


            return true;
        }

    }
}
