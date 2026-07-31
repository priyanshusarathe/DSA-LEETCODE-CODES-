class Solution {

    public int helper(int i, int j, int[] arr,  int dp[][] ) {

        if (i > j)
            return 0;

        int max = 0;
       
       if(dp[i][j]!=-1){
        return dp[i][j];
       }
        for (int k = i; k <= j; k++) {

            int coins =
                    arr[i - 1] * arr[k] * arr[j + 1]
                    + helper(i, k - 1, arr,dp)
                    + helper(k + 1, j, arr,dp);

            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++)
            arr[i + 1] = nums[i];

        int dp[][] = new int[n+2][n+2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(1, n, arr,dp);
    }
}