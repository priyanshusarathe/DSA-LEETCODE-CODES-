class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
         for(int i=0;i<s.length();i++){
              if(s.charAt(i)=='('){
                st.push(sb.length());
              }else if(s.charAt(i)==')'){
                   int start = st.pop();
                   int end = sb.length()-1;
                   reverse(sb,start,end);
              }else{
                sb.append(s.charAt(i));
              }
         }
         return sb.toString();

    }

    public void reverse(StringBuffer sb, int start, int end){
        while(start<end){
              char temp = sb.charAt(start);
              sb.setCharAt(start,sb.charAt(end));
              sb.setCharAt(end,temp);
              start++;
              end--;
        }
    }
}