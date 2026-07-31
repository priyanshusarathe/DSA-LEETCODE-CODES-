class Solution {
    public boolean helper(int i, int j,String s, String t){
         if(i<0){
            return true;
         }
         if(j<0){
            return false;
         }
          boolean ans;
        if(s.charAt(i)==t.charAt(j)){
         ans =helper(i-1,j-1,s,t);
        }else{
        ans = helper(i,j-1,s,t);
        }
   return ans;
    }
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
        return helper(s.length()-1,t.length()-1,s,t);
    }
}