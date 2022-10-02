package practice.bits;

import java.util.Scanner;

class BitConversion {
    public static int conversion(long A,long B)
    {
        int cnt=0;
        long xor=A^B;
        while (xor != 0) {
            cnt++;
            xor &=(xor-1);
        }
        return cnt;

    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        System.out.println(conversion(a,b));
    }
}

