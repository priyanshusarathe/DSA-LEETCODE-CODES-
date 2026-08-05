class Solution {
    public void dfs(boolean [] vis,int k, List<List<Integer>> adj){
        vis[k]=true;

        for(int x :adj.get(k)){
             if(!vis[x]){
                dfs(vis,x,adj);
             }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] x: invocations){
               adj.get(x[0]).add(x[1]);
        }

        boolean [] vis = new boolean[n];
         dfs(vis,k,adj);

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!vis[u] && vis[v]) {
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    all.add(i);
                }
                return all;
            }
        }
         
         for (int i = 0; i < n; i++) {
               if (!vis[i]) {
                 ans.add(i);
                }
       }
   return ans;
    }

}