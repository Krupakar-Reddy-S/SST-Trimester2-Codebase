import java.util.Stack;

public class Calculator {

    public static int calculator(String str) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num.append(str.charAt(i));
                    i++;
                }
                i--; // Adjust index after reading the whole number
                operands.push(Integer.parseInt(num.toString()));
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    process(operands, operators);
                }
                operators.pop(); // Pop '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    process(operands, operators);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            process(operands, operators);
        }

        return operands.pop();
    }

    private static void process(Stack<Integer> operands, Stack<Character> operators) {
        int b = operands.pop();
        int a = operands.pop();
        char operator = operators.pop();

        switch (operator) {
            case '+':
                operands.push(a + b);
                break;
            case '-':
                operands.push(a - b);
                break;
            case '*':
                operands.push(a * b);
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                operands.push(a / b);
                break;
        }
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String expression1 = "2 + 3 * 2 - 4";
        System.out.println(calculator(expression1)); // Output: 4

        String expression2 = "(10 + 3) * 2 - (7 - 6) * (4 + 8)";
        System.out.println(calculator(expression2)); // Output: 14
    }
}
