import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';

            while (!stack.isEmpty() && k > 0 && stack.peek() > n) {
                stack.pop();
                k--;
            }

            stack.push(n);
        }

      
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

      
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

       
        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}