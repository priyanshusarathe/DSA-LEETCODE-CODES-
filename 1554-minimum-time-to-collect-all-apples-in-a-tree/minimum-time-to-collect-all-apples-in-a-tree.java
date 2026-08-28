class Solution {

    public int dfs(int i, int parent, List<List<Integer>> li,
                   List<Boolean> hasApple) {

        int ans = 0;

        for (int x : li.get(i)) {

            if (x == parent) {
                continue;
            }

            int child = dfs(x, i, li, hasApple);

            if (child > 0 || hasApple.get(x)) {
                ans += child + 2;
            }
        }

        return ans;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] x : edges) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        return dfs(0, -1, adj, hasApple);
    }
}