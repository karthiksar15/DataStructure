package practice;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        Map<Character,Integer> mp=new HashMap<Character,Integer>();
//        String s="karthik";
//        for(Character c:s.toCharArray())
//        {
//            mp.put(c,(mp.getOrDefault(c,0))+1);
//        }
//        mp.values().stream().max(Integer::compare).get();
//        System.out.println(postfixExpression("2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +"));
//        System.out.println(postfixExpression("5 11 + 9 5 - + 10 *"));

        Map<Integer,Set<Integer>> grpah=new HashMap<>();


    }


    static int postfixExpression(String exp) {
        Stack<String> st1 = new Stack<>();
        int sum = 0;
        boolean flag = false;
        List<String> list = Arrays.asList("+", "-", "*", "/");
        String[] test = exp.split(" ");

        for (String c : test) {
            if (c.equalsIgnoreCase("+") && (st1.size() > 1)) {
                sum = Integer.parseInt(st1.pop()) + Integer.parseInt(st1.pop());
                st1.push(String.valueOf(sum));
                flag = true;
            } else if (c.equalsIgnoreCase("-") && (st1.size() > 1)) {
                sum = Math.abs(Integer.parseInt(st1.pop()) - Integer.parseInt(st1.pop()));
                st1.push(String.valueOf(sum));
                flag = true;

            } else if (c.equalsIgnoreCase("*") && (st1.size() > 1)) {
                sum = Integer.parseInt(st1.pop()) * Integer.parseInt(st1.pop());
                st1.push(String.valueOf(sum));
                flag = true;
            } else {

                st1.push(c);
            }
        }
        if (flag)
            return Integer.parseInt(st1.pop());
        else
            return Integer.parseInt(exp);
//        for (char c : exp.toCharArray()) {
//            if (c == '+' && (st1.size() > 1)) {
//                sum = (st1.pop() - '0') + (st1.pop() - '0');
//                st1.push((char) (sum + '0'));
//                flag = true;
//            } else if (c == '-' && (st1.size() > 1)) {
//                sum = Math.abs((st1.pop() - '0') - (st1.pop() - '0'));
//                st1.push((char) (sum + '0'));
//                flag = true;
//
//            } else if (c == '*' && (st1.size() > 1)) {
//                sum = (st1.pop() - '0') * (st1.pop() - '0');
//                st1.push((char) (sum + '0'));
//                flag = true;
//            } else if (c >= 48 && c <= 57) {
//                st1.push(c);
//            } else if ((c == '*' || c == '-' || c == '+') && st1.size() == 1) {
//                flag = false;
//            }
//        }
//        if (flag)
//            return (st1.pop() - '0');
//        else
//            return Integer.parseInt(exp);

    }
}
