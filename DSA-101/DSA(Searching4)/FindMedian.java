public class FindMedian {

    /* 
     * Given 2 sorted Arrays.
     * Find the median of the array which is the result of merging the given Arrays.
     * 
     * Ex:
     *      A: {3, 5, 7, 10, 12 }
     *      B: {1, 2, 8, 10, 11, 13, 16 }
     *      
     *      merged Array = {1, 2, 3, 5, 7, 8, 10, 10, 11, 12, 13, 16 }
     *                                     _____
     *      median = (8 + 10)/2 --> 9
    */

    public static double findMedian(int[] A, int[] B){
        int n = A.length;
        int m = B.length;

        if (n > m) {
            return findMedian(B, A);
        }

        int start = 0;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int partitionA = mid;
            int partitionB = (n + m + 1) / 2 - partitionA;

            int leftMaxA = (partitionA == 0) ? Integer.MIN_VALUE : A[partitionA - 1];
            int rightMinA = (partitionA == n) ? Integer.MAX_VALUE : A[partitionA];

            int leftMaxB = (partitionB == 0) ? Integer.MIN_VALUE : B[partitionB - 1];
            int rightMinB = (partitionB == m) ? Integer.MAX_VALUE : B[partitionB];

            if (leftMaxB <= rightMinA && leftMaxA <= rightMinB) {
                if ((n + m) % 2 == 1) {
                    return (double) Math.max(leftMaxA, leftMaxB);
                } 
                else {
                    return (double) (Math.max(leftMaxA, leftMaxB) + Math.min(rightMinA, rightMinB)) / 2.0;
                }
            } 
            else if (leftMaxB > rightMinA) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int A[] = {1, 2 };
        int B[] = {3, 4 };

        System.out.println(findMedian(A, B));
    }
}
