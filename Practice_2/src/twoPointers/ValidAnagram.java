package twoPointers;

public class ValidAnagram {

    public boolean validAnagram(String s, String t) {
        int[] s1=new int[256];
        int[] s2=new int[256];
        for (int i = 0; i <s.length() ; i++) {
            s1[s.charAt(i)]++;
        }
        for (int i = 0; i <t.length() ; i++) {
            s2[t.charAt(i)]++;
        }
        for (int i = 0; i <256 ; i++) {
            if(s1[i]!=s2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "anagram";
        String s2 = "agaram";
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.validAnagram(s1, s2));


    }
}
