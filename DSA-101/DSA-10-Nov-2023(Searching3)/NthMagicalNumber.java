public class NthMagicalNumber {

    /* 
     * Given 3 numbers N, A, B, 
     * return the Nth number divisible by A or B.
    */

    // Calculate the Greatest Common Divisor (GCD) using Euclidean algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Calculate the Least Common Multiple (LCM)
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Check how many magical numbers are less than or equal to x
    private static long countMagicalNumbers(long x, int a, int b) {
        return x / a + x / b - x / lcm(a, b);
    }

    // Binary search to find the nth magical number
    public static int nthMagicalNumber(int N, int A, int B) {
        int mod = 1_000_000_007;
        long low = Math.min(A, B);
        long high = Math.min(A, B) * (long) N;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countMagicalNumbers(mid, A, B) < N) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (low % mod);
    }

    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(5, 2, 3));
    }
}
