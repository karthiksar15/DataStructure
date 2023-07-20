package twoPointers;

public class ReverseString {

    public void reverseString(char[] s) {
        int strt = 0;
        int end = s.length - 1;
        while (strt < end) {
            char temp = s[strt];
            s[strt] = s[end];
            s[end] = temp;
            strt++;
            end--;
        }
        for (char c : s) {
            System.out.println(c);
        }

    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        rs.reverseString(s);
    }
}
