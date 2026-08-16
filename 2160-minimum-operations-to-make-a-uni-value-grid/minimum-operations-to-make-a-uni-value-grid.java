class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int [] arr = new int[n*m];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                  arr[k]=grid[i][j];
                  k++;
            }
        }
        Arrays.sort(arr);
        int ans=0;
        int val = arr[arr.length/2];
        for(int i=0;i<arr.length;i++){
              
              if(arr[i]<val){
                  while(arr[i]<val){
                      arr[i]=arr[i]+x;
                      ans++;
                  }
                  if(arr[i]>val){
                    return -1;
                  }
              }else{
                    while(arr[i]>val){
                        arr[i]=arr[i]-x;
                        ans++;
                    }
                    if(arr[i]<val){
                        return -1;
                    }
              }
        }
   return ans;
    }
}