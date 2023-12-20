public class MinStackExample {
    public static void main(String[] args) throws Exception{
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(-1);
        stack.push(4);
        System.out.println("Stack: " + stack);

        System.out.println("Minimum element: " + stack.getMin());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Stack: " + stack);

        System.out.println("Minimum element: " + stack.getMin());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Stack: " + stack);

        System.out.println("Minimum element: " + stack.getMin());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Stack: " + stack);
    }
}
