class Solution {
     public int helper(int i,int k,int [] arr, int dp[]){
        if(i==arr.length){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }
        int ans = Integer.MIN_VALUE;
        int max =0;
        for(int j=i;j<Math.min(arr.length,i+k);j++){
             max = Math.max(max, arr[j]);
              int len = j - i + 1;
              ans = Math.max(ans,max* len +helper(j+1,k,arr,dp));

        }
   return dp[i]=ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length+1];
        Arrays.fill(dp,-1);
        return helper(0,k,arr,dp);

    }
}