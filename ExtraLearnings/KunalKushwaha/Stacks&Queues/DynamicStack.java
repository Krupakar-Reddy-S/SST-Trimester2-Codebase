public class DynamicStack extends SizedStack{
    
    public DynamicStack() {
        super(); // this will call SizedStack();
    }

    public DynamicStack(int size) {
        super(size); // this will call SizedStack(int size)
    }

    @Override
    public boolean push(int item) {
        // this take scare of the stack being full
        if (this.isFull()) {
            int temp[] = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }

        // at this point we know that array is not full
        return super.push(item);
    }
} 
