package graph;

public class NumberOfUndirectedGraph {

    static class DisjointNOUG{
        private int[] root;
        private int[] rank;
        private int count;
        private boolean[] visited;
        public DisjointNOUG(int size)
        {
            root=new int[size];
            rank=new int[size];
            visited=new boolean[size];
            for (int i = 0; i <size ; i++) {
                root[i]=i;
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
            if(!visited[x])
                visited[x]=true;
            if(!visited[y])
                visited[y]=true;
            if(rootX!=rootY)
            {
                if(rank[rootX]>rank[rootY])
                {
                    root[rootY]=rootX;
                }

                else if(rank[rootY]>rank[rootX])
                {
                    root[rootX]=rootY;
                }

                else
                {
                    root[rootY]=rootX;
                    if(rank[rootX]!=0 && rank[rootY]!=0)
                    {
                        count=count-2;
                        rank[rootX]--;     //[0,1 2,3 0,3] to satify this case
                        rank[rootY]--;

                    }

                    rank[rootX]++;
                    count++;
                }


            }
        }
        public int getCount()
        {
            for (boolean chk:visited) {   //if any vertices left to process
                if(!chk)
                    count++;
            }
            return this.count;
        }


    }

    public static void main(String[] args) {
//        int n=5;
        int n=4;
//        int[][] edges={{0,1},{1,2},{2,3},{3,4}};
        int[][] edges={{2,3},{1,2},{1,3}};
        NumberOfUndirectedGraph.DisjointNOUG ds= new DisjointNOUG(n);
        for (int i = 0; i <edges.length ; i++) {
            ds.union(edges[i][0],edges[i][1]);
        }
        System.out.println(ds.getCount());

    }
}
