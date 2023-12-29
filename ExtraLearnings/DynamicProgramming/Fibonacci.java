public class Fibonacci {

    // TC = O(2^N), SC = O(N)
    public static int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // TC = O(N), SC = O(N)
    public static int fibonacciOptimized(int n) {
        int fib[] = new int[n + 1];
        fib[0] = 0;

        if (n > 0) {
            fib[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i-2];
        }

        return fib[n];
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci Recursive:");
        long start1 = System.currentTimeMillis();
        System.out.println(fibonacciRecursive(30));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1 + "ms");

        System.out.println();
        
        System.out.println("Fibonacci Optimized:");
        long start2 = System.currentTimeMillis();
        System.out.println(fibonacciOptimized(30));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2 + "ms");
    }
}