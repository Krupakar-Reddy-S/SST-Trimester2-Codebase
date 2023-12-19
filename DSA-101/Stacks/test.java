public class test {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

        // Output:
        // 3
        // 3
        // 2
        // 1
        // true
        // false
        
    }
}
