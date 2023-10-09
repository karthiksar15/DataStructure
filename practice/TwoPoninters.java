import java.util.ArrayList;
import java.util.List;

public class TwoPoninters {

    public static void main(String[] args) {
        String check="amna";
        // isPalindrome(check);
        int[] nums={1, 2, 4, 6, 8, 9, 14, 15};
        int target=13;
        // findTarget(nums, target);
        int[] num1={1,3,5,7,9};
        int[] num2={2,4,6,8,10};
        // sortTwo(num1,num2);
        String s="krjk";
        String t="karthik";
        isSubSequence(s,t);
    }

    public static void isPalindrome(String test)
    {
             int i=0,j=test.length()-1;
             boolean flag=true;
             while(i<j)
             {
                if(test.charAt(i)!=test.charAt(j))
                {
                    System.out.println("Not a palindrome");
                    flag=false;
                    break;
                }
                i++;
                j--;
             }
             if(flag)
             System.out.println("Is a palindrome");
    }
    public static void findTarget(int[] nums,int target)
    {
        int i=0,j=nums.length-1;
        int sum=0;
        boolean flag=false;
        while(i<j)
        {
              sum=nums[i]+nums[j];
              if(sum==target)
              {
                System.out.println("found");
                flag=true;
                break;
              }
              else if(sum>target)
              {
                j--;
              }else
              {
                i++;
              }
        }
        if(!flag)
        System.out.println("not found");
    }
    public static void sortTwo(int[] num1,int[] num2)
    {
             int i=0,j=0;
             List<Integer> result=new ArrayList<>();
             while(i<num1.length && j<num2.length)
             {
                if(num1[i]<num2[j])
                {
                    result.add(num1[i]);
                    i++;
                }else
                {
                    result.add(num2[j]);
                    j++;
                }
             }
             while(i<num1.length)
             {
                result.add(num1[i]);
                i++;
             }
              while(j<num2.length)
             {
                result.add(num2[j]);
                j++;
             }
             System.out.println(result);
    }

    public static void isSubSequence(String s,String t)
    {
        int i=0,j=0;
        while(i<s.length() && j<t.length())
        {
          if(t.charAt(j)==s.charAt(i))
          {
            i++;
          }
          j++;
        }
        if(i==s.length())
        {
            System.out.println("found");
        }else
        {
            System.out.println("not found");
        }
    }
    
}
