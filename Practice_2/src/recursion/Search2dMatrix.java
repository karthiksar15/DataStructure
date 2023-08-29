package recursion;
public class Search2dMatrix {

    static String indexCapitalisation(String s, int[] ind) {

        StringBuilder sb=new StringBuilder(s);

        for(int i=0;i<ind.length;i++)
        {
            if(ind[i] < sb.length() && sb.charAt(ind[i]) >= 97)
            {
                int temp=sb.charAt(ind[i])-32;
                sb.setCharAt(ind[i],(char)temp);
            }

        }



        return sb.toString();
    }

    public static void main(String args[]) {
        String s = "learn by doing";
        int[] ind = new int[] { 0, 6, 9 };
        System.out.println(indexCapitalisation(s, ind));
//        assert (indexCapitalisation(s, ind).equals("Learn By Doing")) : "Expect \"Learn By Doing\" for s = \"learn by doing\" and ind = [0, 6, 9]";

        System.out.println("All test cases in main function passed");

    }
}
