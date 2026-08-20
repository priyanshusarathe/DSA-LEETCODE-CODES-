class Solution {
    public int helper(int i,int[] coins , int amount, int [][] dp){
     
     if(i<0){
        return Integer.MAX_VALUE;
     }
     if(dp[i][amount]!=-1){
        return dp[i][amount];
     }

     if(amount==0){
        return 0;
     }
      int notTake = helper(i-1,coins,amount,dp);
      int take = Integer.MAX_VALUE;

     if(amount>=coins[i]){
         int res = helper(i,coins,amount-coins[i],dp);
         if(res!= Integer.MAX_VALUE){
            take = 1 + res;
         }

     }
     return dp[i][amount] = Math.min(notTake,take);
     }
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int ans = helper(coins.length-1,coins,amount,dp);
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }

}