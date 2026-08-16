class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination){
            return true;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
              adj.add(new ArrayList<>());
        }
          
       for(int[] x : edges){
          int u = x[0];
          int v = x[1];
          adj.get(u).add(v);
          adj.get(v).add(u);
         }
         boolean [] vis = new boolean[n];
         Queue<Integer> q = new LinkedList<>();
         q.offer(source);
         vis[source]=true;
         while(!q.isEmpty()){
            int a = q.poll();
          

            for(int b : adj.get(a)){
                   if(b==destination){
                    return true;
                   }
                   if(!vis[b]){
                    vis[b]=true;
                   q.offer(b);
                   }
            }
         }




 return false;
    }
}