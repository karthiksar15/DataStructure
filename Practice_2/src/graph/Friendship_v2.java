package graph;

import java.util.Arrays;

public class Friendship_v2 {

    class Solution {
        public int earliestAcq(int[][] logs, int n) {
            Arrays.sort(logs, (entry1, entry2) -> {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            });
            UnionFind_2 uf = new UnionFind_2(n);
            for (int[] num : logs) {
                uf.union(num[1], num[2]);
                if(uf.findAll())
                {
                    return num[0];

                }
            }

            return -1;

        }
    }

    class UnionFind_2 {
        private int[] rank;
        private int[] parent;
        private int count;
        private boolean[] visited;


        public UnionFind_2(int n) {
            parent = new int[n];
            rank = new int[n];
            visited=new boolean[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (node == parent[node])
                return node;
            return parent[node] = find(parent[node]);
        }

        public void union(int node1, int node2) {
            int x = find(node1);
            int y = find(node2);
            if(!visited[node1])
                visited[node1]=true;
            if(!visited[node2])
                visited[node2]=true;
            if(x!=y)
            {
                if(rank[x]>rank[y])
                {
                    parent[y]=x;
                }else if(rank[y]>rank[x])
                {
                    parent[x]=y;
                }else
                {
                    parent[y]=x;
                    if(rank[x]!=0 && rank[y]!=0)
                    {
                        rank[x]--;
                        rank[y]--;
                        count=count-2;
                    }
                    rank[x]++;
                    count++;
                }
            }
        }
        public boolean findAll()
        {
            boolean visited_flag=true;
            for (boolean chk:visited) {   //if any vertices left to process
                if(!chk)
                {
                    visited_flag=false;
                    break;
                }
            }
            if(visited_flag && this.count==1)
                return true;
            return false;
        }

    }
}
