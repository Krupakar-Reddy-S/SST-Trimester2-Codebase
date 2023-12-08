public class BitOperations {

    public static int and(int a, int b){
        return a & b;
    }

    public static int or(int a, int b){
        return a | b;
    }

    public static int not(int a){
        return ~ a;
    }

    public static int xor(int a, int b){
        return a ^ b;
    }

    public static int rightShift(int a){
        return a >> 1;
    }

    public static int leftShift(int a){
        return a << 1;
    }

    public static void main(String[] args) {
        System.out.println(and(11,1));
        System.out.println(or(11, 1));
        System.out.println(not(10));
        System.out.println(xor(4, 1));
        System.out.println(rightShift(10));
        System.out.println(leftShift(10));
    }
}
