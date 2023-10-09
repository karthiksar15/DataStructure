package graph;

public class DisjointSet {

    private int[] rank;
    private int[] root;

    public DisjointSet(int size)
    {
        rank=new int[size];
        root=new int[size];
        for (int i = 0; i <size ; i++) {
            root[i]=i;
            rank[i]=1;
        }
    }

    public int find(int x)
    {
        if(root[x]==x)
            return x;
        return x=find(root[x]);
    }

    public void union(int x,int y)
    {
        int rootX=find(x);
        int rootY=find(y);

        if(rootX!=rootY)
        {
            if (rank[rootX]>rank[rootY]) {
                root[rootY]=rootX;
                rank[rootX]+=rank[rootY];
            }
            else if (rank[rootY]>rank[rootX]) {
                root[rootX]=rootY;
                rank[rootY]+=rank[rootX];
            }
            else{
                root[rootY]=rootX;
                rank[rootX]+=rank[rootY];
            }
        }
    }

    public boolean isConnected(int findX,int findY)
    {
        if(find(findX)==find(findY))
            return true;
        return false;
    }



    public static void main(String[] args) {
        DisjointSet uf = new DisjointSet(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.isConnected(1, 5)); // true
        System.out.println(uf.isConnected(5, 7)); // true
        System.out.println(uf.isConnected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.isConnected(4, 9)); // true

    }
}
