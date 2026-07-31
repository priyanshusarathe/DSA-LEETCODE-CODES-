class Solution {
    public int helper(int i, int j, int [] arr , int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
        int cost = arr[j+1]-arr[i-1]+helper(i,k-1,arr,dp)+helper(k+1,j,arr,dp);
        mini = Math.min(mini,cost);
      }
        return dp[i][j] =mini;
        }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len = cuts.length;
        int [] arr = new int[len+2];

        arr[0]=0;
        arr[len+1]=n;

        for(int i=0;i<len;i++){
            arr[i+1]=cuts[i];
        }

        int dp[][] = new int[len+2][len+2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(1,len,arr,dp);

    }
}