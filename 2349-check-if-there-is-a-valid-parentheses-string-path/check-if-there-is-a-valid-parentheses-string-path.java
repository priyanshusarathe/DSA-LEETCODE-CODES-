class Solution {
    public boolean helper(char[][]grid,int n, int m, int i, int j, int balance, Boolean [][][] dp){
           if(i>=n || j>=m){
              return false;
           }
             if(grid[i][j]=='('){
            balance++;
           }else{
            balance--;
           }
           if(balance<0){
            return false;
           }
           
           if(dp[i][j][balance]!=null){
            return dp[i][j][balance];
           }
           
         
           if(i==n-1 && j==m-1){
              if(balance==0){
                return true;
              }
           }
           return dp[i][j][balance]= helper(grid,n,m,i+1,j,balance,dp) || helper(grid,n,m,i,j+1,balance,dp);
    }
    public boolean hasValidPath(char[][] grid) {
        int balance=0;
        int n = grid.length;
        int m = grid[0].length;
        Boolean [][][] dp = new Boolean[n][m][n+m+1];
        return helper(grid,n,m,0,0,0,dp);
    
    }
}