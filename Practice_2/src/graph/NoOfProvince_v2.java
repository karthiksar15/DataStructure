package graph;

class Solution1{

    public int findCircleNum(int[][] isConnected) {
        boolean[] chk=new boolean[isConnected.length];
        int counter=0;
        for (int i = 0; i < isConnected.length ; i++) {
            if (!chk[i]) {
                dfs(isConnected,chk,i);
                counter++;
            }
        }
        return counter;
    }
    public void dfs(int[][] isConnected,boolean[] chk,int src)
    {
        if(!chk[src])
        {
            chk[src]=true;
            for (int i = 0; i <isConnected[src].length ; i++) {
                if(isConnected[src][i]==1)
                    dfs(isConnected,chk,i);
            }
        }
    }
}

public class NoOfProvince_v2 {
    public static void main(String[] args) {
        Solution1 ss=new Solution1();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(ss.findCircleNum(isConnected));
    }
}
