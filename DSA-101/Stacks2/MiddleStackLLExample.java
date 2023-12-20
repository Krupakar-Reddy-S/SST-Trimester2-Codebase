public class MiddleStackLLExample {
    public static void main(String[] args) throws Exception{
        MiddleStackLL stack = new MiddleStackLL();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Stack: " + stack);

        System.out.println("Middle element: " + stack.getMid());
        System.out.println("Removed middle element: " + stack.removeMid());
        System.out.println("Stack: " + stack);

        System.out.println("Middle element: " + stack.getMid());
        System.out.println("Removed middle element: " + stack.removeMid());
        System.out.println("Stack: " + stack);

        System.out.println("First element: " + stack.pop());
        System.out.println("Stack: " + stack);
    }
}
