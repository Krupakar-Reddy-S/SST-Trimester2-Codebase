import java.util.Stack;

public class DoubleCharacterTrouble {

    /* 
     * Given a  string, remove all consecutive duplictaes and return the string.
     * 
    */

    public static String doubleCharacterTrouble(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(str.charAt(i));
            } 
            else {
                if(stack.peek() == str.charAt(i)) {
                    stack.pop();
                } 
                else {
                    stack.push(str.charAt(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "aaabccddd";
        System.out.println(doubleCharacterTrouble(str1)); // abd

        String str2 = "ggefggebbbaddg";
        System.out.println(doubleCharacterTrouble(str2)); // efebag
        
        String str3 = "azxxzy";
        System.out.println(doubleCharacterTrouble(str3)); // ay
    }
}
