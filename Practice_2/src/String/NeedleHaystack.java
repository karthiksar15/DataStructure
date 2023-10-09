package String;

public class NeedleHaystack {

    public int strstr(String haystack,String needle)
    {
        String temp="";
        int start=0;
        for (int i = 0; i < haystack.length(); i++) {
            temp=temp+haystack.charAt(i);
               if(needle.length()==temp.length())
               {
                   if(temp.equalsIgnoreCase(needle))
                   {
                       return i-(needle.length()-1);
                   }
                   temp="";
                   i=start;
                   start=i+1;
               }
        }
        return -1;
    }
    public static void main(String[] args) {
        NeedleHaystack nh=new NeedleHaystack();
        String haystack="leetcode";
        String needle="code";
        System.out.println(nh.strstr(haystack,needle));
    }
}
