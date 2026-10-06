class Solution {
    public int minAddToMakeValid(String s) {
        int ans =0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
              char c = s.charAt(i);
              if(c=='('){
                st.push(c);
              }else{
                   if(!st.isEmpty() && st.peek()=='('){
                       st.pop();
                   }else{
                    st.push(c);
                   }
              }
        }

        while(!st.isEmpty()){
            ans++;
            st.pop();
        }
        return ans;
        
    }
}