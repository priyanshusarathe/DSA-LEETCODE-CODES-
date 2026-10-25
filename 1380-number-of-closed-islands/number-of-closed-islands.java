class Solution {
    public boolean dfs(int i, int j,int n, int m,int[][]grid){
        if(i>=n || j>=m|| i<0 || j<0){
            return false;
        }
          if(grid[i][j]==1){
            return true;
          }
          grid[i][j]=1;
     boolean top=dfs(i+1,j,n,m,grid);//top
     boolean bottom=dfs(i-1,j,n,m,grid);//bottom
     boolean left=dfs(i,j-1,n,m,grid);//left
     boolean right=dfs(i,j+1,n,m,grid);//right

     

   return top&& bottom && left && right;
    }
    public int closedIsland(int[][] grid) {
        int closeisland=0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                  
                   if (grid[i][j] == 0) {
                    if (dfs(i, j, n, m, grid)) {
                        closeisland++;
                    }
                   }
            }
        }

 return closeisland;
    }
     
}