public class Tribonacci {

    // TC = O(3^N), SC = O(N)
    public static int tribonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return tribonacciRecursive(n - 1) + tribonacciRecursive(n - 2) + tribonacciRecursive(n - 3);
    }

    // TC = O(N), SC = O(N)
    public static int tribonacciOptimised(int n) {
        int trib[] = new int[n + 1];
        trib[0] = 0;

        if (n > 0) {
            trib[1] = 0;
        }

        if (n > 1) {
            trib[2] = 1;
        }

        for (int i = 3; i <= n; i++) {
            trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
        }

        return trib[n];
    }

    public static void main(String[] args) {
        System.out.println("Tribonacci Recursive:");
        long start1 = System.currentTimeMillis();
        System.out.println(tribonacciRecursive(30));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1 + "ms");

        System.out.println();

        System.out.println("Tribonacci Optimized:");
        long start2 = System.currentTimeMillis();
        System.out.println(tribonacciOptimised(30));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2 + "ms");
    }
}
