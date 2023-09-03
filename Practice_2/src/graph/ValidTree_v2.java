package graph;

class Solution4 {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        UnionFind1 uf=new UnionFind1(n);
        if (edges.length != n - 1) return false;

        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!uf.union(A, B)) {
                return false;
            }
        }

        return true;
    }
    class UnionFind1{
        int[] root;
        int[] rank;
        int count;
        public UnionFind1(int size)
        {
            root=new int[size];
            rank=new int[size];
            count=size;
            for(int i=0;i<size;i++)
            {
                root[i]=i;
                rank[i]=1;
            }
        }
        public int find(int x)
        {
            if(root[x]==x)
                return x;
            return root[x]=find(root[x]);
        }
        public boolean union(int rootX,int rootY)
        {
            int x=find(rootX);
            int y=find(rootY);
            if (x == y) {
                return false;
            }

            if(rank[x]<rank[y])
            {
                root[y]=x;
                rank[x]+=rank[y];
            }else
            {
                root[x]=y;
                rank[y]+=rank[x];
            }


            return true;
        }

    }
}