package dp;

import java.util.Scanner;

public class ClimbingStairs {

    public int climbingStairs(int n) {
        int m = 2; //only two ways to climb steps 1 step or 2 step
        return countWaysUtil(n + 1, m);
    }

    public int countWaysUtil(int n,int m)
    {
        int[] res=new int[n];
        res[0]=1;
        res[1]=1;
        for (int i = 2; i <n ; i++) {
            for (int j = 0; j <=m && j<=i ; j++) {
                res[i]+=res[i-j];
            }
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int count=scan.nextInt();
        ClimbingStairs cs=new ClimbingStairs();
        System.out.println(cs.climbingStairs(count));
    }
}
