import java.util.Scanner;

public class Floor {

    public static int floor(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        int ans = Integer.MIN_VALUE;

        while( start >= end){
            int mid = (start + end) / 2;

            if(A[mid] == target){
                return A[mid];
            }
            if(A[mid] > target){
                end = mid - 1;
            }
            else{
                if(ans > A[mid]){
                    ans = A[mid];
                }
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        int A[] = {-6, -3, 0, 4, 6, 7, 11, 13, 19};
        System.out.println(floor(A, target));

        sc.close();
    }
}
