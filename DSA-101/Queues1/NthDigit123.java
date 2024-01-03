import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NthDigit123 {

    /* 
     * Companies: Amazon
     * 
     * Given a number N, find the Nth digit which can be formed only using 1, 2, 3. X
     * 
     * Given a number N, return the first N numbers that can be formed with 1, 2, 3. 
     * 
    */

    public static void nthDigit123(int N, ArrayList<Integer> list) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        q.add("3");

        while (N-- > 0) {
            String curr = q.remove();
            list.add(Integer.parseInt(curr));
            q.add(curr + "1");
            q.add(curr + "2");
            q.add(curr + "3");
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        nthDigit123(1000, list);
    }
}
