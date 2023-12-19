import java.util.*;

public class SizedStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int top = -1;

    public SizedStack() {
        this(DEFAULT_SIZE);
    }

    public SizedStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return false;
        }

        data[++top] = item;
        return true;
    }

    public int pop() throws Exception{
        if (isEmpty()) {
            throw new Exception("Stack is Empty");
        }

        return data[top--];
    }

    public int peek() throws Exception{
        if (isEmpty()) {
            throw new Exception("Stack is Empty");
        }

        return data[top];
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(data, 0, top + 1));
    }
}
