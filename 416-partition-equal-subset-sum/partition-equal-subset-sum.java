class Solution {
    public boolean helper(int i,int target,int [] nums,Boolean[][] dp){
        if(i<0){
            return false;
        }
        if(target==0){
            return true;
        }
        if(dp[i][target]!=null){
            return dp[i][target];
        }
        boolean skip = helper(i-1,target,nums,dp);
        boolean take = false;
        if(nums[i]<=target){
            take = helper(i-1,target-nums[i],nums,dp);
        }

        return dp[i][target] =skip || take;
    }
    public boolean canPartition(int[] nums) {
        int totalsum = 0;
        for(int i=0;i<nums.length;i++){
             totalsum+=nums[i];
        }

        if(totalsum%2!=0){
            return false;
        }
        int half = totalsum/2;
        Boolean [][] dp = new Boolean[nums.length][half+1];
        return helper(nums.length-1,half,nums,dp);
    }
}