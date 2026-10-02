class Solution {
    public void helper(int n,List<String> li,StringBuffer sb,int open, int close){
        if(sb.length()==2*n){
            li.add(sb.toString());
            return;
        }
        if(open<n){
        helper(n,li,sb.append('('),open+1,close);
          sb.deleteCharAt(sb.length()-1);
        }

        if (close < open) {
            sb.append(')');
            helper(n, li, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
       
       
    public List<String> generateParenthesis(int n) {
          StringBuffer sb = new StringBuffer();
          List<String> li = new ArrayList<>();
          helper(n,li,sb,0,0);
          return li;
    }
}