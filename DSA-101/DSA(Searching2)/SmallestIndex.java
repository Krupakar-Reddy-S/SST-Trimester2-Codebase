import java.util.Scanner;

public class SmallestIndex {

    /* 
     * Given an sorted array and an target,
     * Return its smallest index of the target.
    */

    public static int smallestIndex(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        int minIndex = -1;

        while( start <= end){
            int mid = (start + end) / 2;

            if(A[mid] == target){
                minIndex = mid;
                end = mid - 1;
            }
            else if(A[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        int A[] = {-5, -5, -3, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 8};
        System.out.println(smallestIndex(A, target));

        sc.close();
    }
}
