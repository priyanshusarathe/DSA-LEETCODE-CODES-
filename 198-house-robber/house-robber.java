class Solution {
    // public int helper(int i, int[] nums,int [] dp){
    //     if(i<0){
    //         return 0;
    //     }
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }
    //     int skip = helper(i-1,nums,dp);
    //     int take = nums[i]+helper(i-2,nums,dp);
    //     return dp[i]= Math.max(skip,take);
    // } memoization
    public int rob(int[] nums) {
        
        int [] dp  = new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        if(nums.length==1){
            return dp[0];
        }
        dp[1]=Math.max(nums[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
              dp[i]= Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
      return  dp[nums.length-1];
    }
}