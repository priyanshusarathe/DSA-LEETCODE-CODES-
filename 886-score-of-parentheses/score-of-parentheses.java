class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char c : s.toCharArray()) {

            if (c == '(') {
                st.push(0);
            } else {
                int inner = st.pop();

                int value;
                if (inner == 0) {
                    value = 1;         
                } else {
                    value = 2 * inner;  
                }

                st.push(st.pop() + value);
            }
        }

        return st.peek();
    }
}