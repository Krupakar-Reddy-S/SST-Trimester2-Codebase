import java.util.Scanner;

public class RotatedIndex {

    /* 
     * Given an array which is rotated, find a target
     * (all elements are distinct)
     */

    public static int pivot(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] >= A[0]) {
                if (target >= A[0] && target < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[A.length - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the target number: ");
        int target = sc.nextInt();

        int A[] = {10, 20, 30, -1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = pivot(A, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } 
        else {
            System.out.println("Target not found in the array.");
        }

        sc.close();
    }
}
