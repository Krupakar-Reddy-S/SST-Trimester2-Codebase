import java.util.Stack;

public class MinStack {
    // Use Stack from Collections to implement the getMin() method
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
    
    public void push(int data) {
        this.stack.push(data);
        if (this.minStack.isEmpty() || data <= this.minStack.peek()) {
            this.minStack.push(data);
        }
    }

    public int pop() throws Exception {
        if (this.stack.isEmpty()) {
            throw new Exception("Stack is empty");
        }
        int data = this.stack.pop();
        if (data == this.minStack.peek()) {
            this.minStack.pop();
        }
        return data;
    }

    // TC = O(1)
    public int getMin() throws Exception {
        if (this.minStack.isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return this.minStack.peek();
    }

    public String toString() {
        return this.stack.toString();
    }
}
