class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image[sr][sc]==color){
                return image;
            }
            int [][] dir = {{1,0}
                           ,{-1,0}
                           ,{0,1}
                           ,{0,-1}
            };
            int n = image.length;
            int m = image[0].length;

            boolean [][] vis = new boolean[n][m];

            Queue<int[]> q  = new LinkedList<>();
            q.offer(new int[]{sr,sc});
            vis[sr][sc]=true;
            int val = image[sr][sc];
            while(!q.isEmpty()){
                  int [] curr = q.poll();
                   int r = curr[0];
                   int c = curr[1];
                  
                   image[r][c]=color;
                   for(int [] x : dir){
                          int nr = r + x[0];
                          int nc = c + x[1];
                          if(nr>=0 && nc>=0 && nr<image.length && nc<image[0].length && !vis[nr][nc]){
                               if(image[nr][nc]==val){
                                  q.offer(new int[]{nr,nc});
                                  image[nr][nc]=color;
                               }
                               vis[nr][nc]=true;
                          }
                   }
            }
   return image;
    }
}