package graph;


import java.util.Objects;

class Solution3{

    class Pair{
        Integer a;
        Integer b;
        public Pair(Integer a,Integer b)
        {
            this.a=a;
            this.b=b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return Objects.equals(a, pair.a) && Objects.equals(b, pair.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
    public boolean validTree(int n, int[][] edges) {

        for (int i = 0; i < edges.length; i++) {


        }

    return false;
    }
}
public class ValidTree {
    public static void main(String[] args) {
        int n=5;
        int[][] edges={{0,1},{0,2},{0,3},{1,4}};
        Solution3 ss=new Solution3();
        ss.validTree(n,edges);

    }
}
