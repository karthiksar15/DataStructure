package recursion;

public class KthRow {

public int find(int n,int k)
{
    if(n==1||k==1)
        return 0;
    int mid=(int)Math.pow(2,n-1)/2;
    if(k<=mid)
    {
        return find(n-1,k);
    }else
    {
        return find(n-1,k-mid)==0?1:0;
    }
}

    public static void main(String[] args) {

        KthRow kth=new KthRow();
        int n=2,k=1;
        System.out.println(kth.find(3,3));


    }
}
