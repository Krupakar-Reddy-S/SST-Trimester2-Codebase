public class BinarySearch {

    public static int binarySearch(int[] A, int target, int start, int end){     
        int mid = (start + end) / 2;

        if(A[mid] == target){
            return mid;
        }
        if(A[mid] > target){
            binarySearch(A, target, start, mid-1);
        }
        else{
            binarySearch(A, target, mid+1, end);
        }

        return -1;

    }

    public static int binarySearch1(int[] A, int target){
        int start = 0;
        int end = A.length;
        
        while(start <= end){
            int mid = (start + end) / 2;

            if(A[mid] == target){
                return mid;
            }
            if(A[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int A[] = {1, 2, 4, 6, 8, 10, 12, 14};

        System.out.println(binarySearch(A, 4, 0, A.length-1));
    }
}
