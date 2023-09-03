package stack;

import java.util.Stack;
import java.util.Vector;

public class Rpn {

    static int reversePolishNotation(Vector<String> vec) {

        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";
        for (String token : vec) {

            if (!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int number2 = stack.pop();
            int number1 = stack.pop();

            int result = 0;

            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }

            stack.push(result);

        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Vector<String> vec = new Vector<>();
        vec.add("2");
        vec.add("1");
        vec.add("+");
        vec.add("3");
        vec.add("*");
        System.out.println(Rpn.reversePolishNotation(vec));
    }
}
