package String;

public class BinaryV2 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0, sum = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry==1)
            res=res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        BinaryV2 v2 = new BinaryV2();
        System.out.println(v2.addBinary("11", "1"));
    }
}
