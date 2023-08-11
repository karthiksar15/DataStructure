package practice.recursion;

public class StringCheck {

    public static void main(String[] args) {
        String check="Karthik";
        Reverse.printReverse(check.toCharArray());
        Reverse.reverse1(check.toCharArray());



    }
}

class Reverse{
    public static void printReverse(char[] str)
    {
            helper(0,str);
    }
    private static void helper(int index,char[] str)
    {
            if(str==null || index==str.length)
            {
                return;
            }
            helper(index+1,str);
//            System.out.println(str[index]);
    }

    public static void reverse1(char[] str)
    {
        helper1(0,str.length-1,str);
        for (char c: str) {
            System.out.println(c);
        }
    }
    public static void helper1(int start,int end,char[] str)
    {
        if(start>=end)
            return;
        char temp=str[start];
        str[start]=str[end];
        str[end]=temp;

        helper1(start+1,end-1,str);

    }
}