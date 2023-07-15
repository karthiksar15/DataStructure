package practice;

class Check
{
    public int num;
    public Check next;
    public Check(int num)
    {
        this.num=num;
        this.next=null;
    }
}

public class ObjectTest {

    public static void main(String args[])
    {
        Check c1=new Check(1);
        Check c2=new Check(2);
        Check c3=new Check(3);
        Check c4=c2;
        printObj(c2);
        for(int i=0;i<2;i++)
        {
            c4.num=6;
            System.out.println("c4 for loop---"+c4.num);
        }
        System.out.println("c4  outside for loop---"+c4.num);
        c4.num=5;
        System.out.println("c4---"+c4);
        System.out.println("c4 val---"+c4.num);
        System.out.println("c2---"+c2);
        System.out.println("c2 val---"+c2.num);


    }
    public static void printObj(Check c2)
    {
        System.out.println("c22---"+c2);
        c2.num=7;
        System.out.println("c22---"+c2.num);
    }
}
