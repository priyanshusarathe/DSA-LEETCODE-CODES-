class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int ans = 0;


        while (!q.isEmpty()) {

            int size = q.size();
            boolean rottenThisMinute = false;

            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nc >= 0 &&
                        nr < n && nc < m &&
                        !vis[nr][nc] &&
                        grid[nr][nc] == 1) {

                        vis[nr][nc] = true;
                        grid[nr][nc] = 2;

                        fresh--;

                        q.offer(new int[]{nr, nc});

                        rottenThisMinute = true;
                    }
                }
            }

            if (rottenThisMinute) {
                ans++;
            }
        }

      
        if (fresh > 0) {
            return -1;
        }

        return ans;
    }
}