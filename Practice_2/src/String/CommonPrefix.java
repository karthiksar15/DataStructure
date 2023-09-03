package String;

public class CommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        int min_size = Integer.MAX_VALUE;

        String result = "";
        char eachChar = 'a';
        for (String str : strs) {
            if (str.length() < min_size)
                min_size = str.length();
        }
        int chk = 0;
        while (index < min_size) {
            chk = 0;
            for (String str : strs) {
                if (chk == 0) {
                    eachChar = str.charAt(index);
                } else {
                    if (eachChar != str.charAt(index))
                        return result;
                }
                chk++;
            }
            result = result + eachChar;
            index++;
        }
        return result;

    }

    public static void main(String[] args) {

        CommonPrefix cp = new CommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(cp.longestCommonPrefix(strs));


    }
}
