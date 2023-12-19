public class Stack {
    private int[] stackArray;
    private int capacity;
    private int top;

    public Stack(int size) {
        capacity = size;
        stackArray = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top < capacity - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public int pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }

    public int peek() {
        if (top >= 0) {
            return stackArray[top];
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == capacity - 1);
    }
}