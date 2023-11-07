import java.util.Scanner;

public class Floor {

    public static int Floor(int[] A, int target){
        int Floor = A[0];

        for(int i = 0; i < A.length; i++){
            if(A[i] < target){
                Floor = A[i];
            }
            else{
                break;
            }
        }

        return Floor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        int A[] = {-6, -3, 0, 4, 6, 7, 11, 13, 19};
        System.out.println();

    }
}
