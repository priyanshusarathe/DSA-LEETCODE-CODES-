class Solution {
    public int helper(int i, int j,String s,String t, int dp[][] ){
        if(j<0){
            return i+1;
        }
        if(i<0){
            return j+1;
        }
        if( dp[i][j]!=-1) {
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
          return  dp[i][j]= helper(i-1,j-1,s,t,dp);
        }
        return dp[i][j]= 1 + Math.min(helper(i-1,j-1,s,t,dp),Math.min(helper(i-1,j,s,t,dp),helper(i,j-1,s,t,dp)));
    }
    public int minDistance(String word1, String word2) {
      
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
          return helper(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
}