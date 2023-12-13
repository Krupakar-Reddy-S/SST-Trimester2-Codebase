import java.util.Stack;

public class ExpressionEvaluator {

    public static double evaluateExpression(String expression) throws Exception {
        String[] tokens = expression.split("\\s+");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new Exception("Invalid expression");
                }
                double operand2 = stack.pop();
                double operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        if (operand2 == 0) {
                            throw new Exception("Cannot divide by zero");
                        }
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new Exception("Invalid operator: " + token);
                }
            } else {
                try {
                    stack.push(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    throw new Exception("Invalid number: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new Exception("Invalid expression");
        }

        return stack.pop();
    }

    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    public static void main(String[] args) {
        try {
            System.out.println(evaluateExpression("10 + 2 * 6"));
            System.out.println(evaluateExpression("100 * 2 + 12"));
            System.out.println(evaluateExpression("(100 + 2) + 12"));
            System.out.println(evaluateExpression("(100 + 2 + 12) / 14"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
