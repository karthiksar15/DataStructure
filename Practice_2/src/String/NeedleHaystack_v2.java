package String;

public class NeedleHaystack_v2 {


    public int strStr(String haystack, String needle) {

        if (haystack.contains(needle)) {

            int beginingIndex = 0;
            int needleIndex = 0;

            for (int i = 0; i < haystack.length(); i++) {

                if (haystack.charAt(i) == needle.charAt(needleIndex)) {
                    beginingIndex = i;
                    int haystackIndex = i;

                    for (int j = 0; j < needle.length(); j++) {
                        if (haystack.charAt(haystackIndex++) == needle.charAt(j)) {
                            needleIndex++;
                        }
                    }
                }

                if (needleIndex == needle.length()) return beginingIndex;

                needleIndex = 0;
            }
        }

        return -1;

    }


    public static void main(String[] args) {
        NeedleHaystack_v2 nh = new NeedleHaystack_v2();
        String haystack = "leetcode";
        String needle = "code";
        System.out.println(nh.strStr(haystack, needle));

    }
}
