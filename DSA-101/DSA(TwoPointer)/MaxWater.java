public class MaxWater {

    /* 
     * Companies: Google, Facebook
     * 
     * Given an Array containing the heigth of n walls.
     * Find max amount of water getting acumalated b/w any two walls
     * 
    */

    public static int maxWater(int[] walls){
        int i = 0;
        int j = walls.length - 1;
        int water = Integer.MIN_VALUE;

        while(i != j){
            int currentWater = Math.min(walls[i], walls[j]) * (j - i);

            if(currentWater > water){
                water = currentWater;
            }
            if(walls[i] < walls[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int A[] = {3, 7, 4, 5, 2 };
        System.out.println(maxWater(A));
    }
}
