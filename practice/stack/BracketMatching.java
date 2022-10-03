package practice.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketMatching {

    public static void main(String[] args) {
        BracketMatching b = new BracketMatching();
        String brack = "{([]())}[]";
        boolean isValid = b.checkIsValid(brack);
        System.out.println("isValid--->" + isValid);
    }

    public boolean checkIsValid(String brackets) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put(']', '[');
        mp.put('}', '{');
        for (Character c : brackets.toCharArray()) {
            if (mp.containsKey(c)) {
                Character topElem = st.empty() ? '#' : st.pop();
                if (topElem != mp.get(c)) {
                    return false;
                }
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
