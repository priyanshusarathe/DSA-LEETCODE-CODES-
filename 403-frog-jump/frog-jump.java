class Solution {
    public boolean helper(int i,int pj, int[] stones, HashMap<Integer,Integer> map,Boolean [][]dp)
    {
         if(i==stones.length-1){
            return true;
         }

         if(dp[i][pj]!=null){
            return dp[i][pj];
         }

         for(int jump = pj-1;jump<=pj+1;jump++){

            if(jump<=0){
                continue;
            }

            int nextposition = stones[i]+jump;
            if(map.containsKey(nextposition)){
                 int nextindex = map.get( nextposition);

                 if(helper(nextindex,jump,stones,map,dp)){
                    return dp[i][pj] =true;
                 }
            }
     
         }
         return dp[i][pj] =false;
}
    public boolean canCross(int[] stones) {
        if(stones.length<2 || stones[1]!=1){
            return false;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }

        Boolean [][] dp = new Boolean[stones.length][stones.length+1];

      return   helper(1,1,stones,map,dp);
    }
}