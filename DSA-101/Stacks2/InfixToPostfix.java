import java.util.Stack;

public class InfixToPostfix {
    /* 
     * Given an infix expression, convert it to postfix and return the result.
     * 
    */

    public static String infixToPostfix(String str) {
        Stack<Character> operators = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c);
            } 
            else if (c == '(') {
                operators.push(c);
            } 
            else if (c == ')') {
                while (operators.peek() != '(') {
                    postfix.append(operators.pop());
                }
                operators.pop();
            } 
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    postfix.append(operators.pop());
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            postfix.append(operators.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        String infix1 = "1 + 2 * 3";
        System.out.println(infixToPostfix(infix1));

        String infix2 = "1 + 2 * 3 - 4";
        System.out.println(infixToPostfix(infix2));

        String infix3 = "(10 + 3) * 2 - (7 - 6) * (4 + 8)";
        System.out.println(infixToPostfix(infix3));
    }
}
