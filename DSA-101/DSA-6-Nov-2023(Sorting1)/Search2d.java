import java.util.Scanner;

public class Search2d {

    // TC = O(N^2), SC = O(1)
    public static boolean search2d(int[][] A, int target){
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                if(A[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean search2d1(int[][] A, int target){
        int i = 0;
        int j = A[0].length -1;

        while(i < A.length && j >= 0){
            if(A[i][j] == target){
                return true;
            }
            if(A[i][j] > target){
                i++;
            }
            else{
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target to search in 2d Array: ");
        int target = sc.nextInt();

        int A[][] = {{5,10,12,15,20}, {8,11,13,17,31}, {10,12,14,22,38}, {15,18,23,28,40}};

        if(search2d1(A, target)){
            System.out.println("Given target " + target + " is present in the 2d Array.");
        }
        else{
            System.out.println("Given target " + target + " is not present in the 2d Array.");

        }

        sc.close();
    }
}
