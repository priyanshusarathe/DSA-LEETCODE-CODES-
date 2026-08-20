class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        boolean[][][] visited = new boolean[m][n][k + 1];

        Queue<int[]> q = new LinkedList<>();

        // row, col, remaining k
        q.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;

        int step = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // One BFS level = one step
            for (int s = 0; s < size; s++) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int remainingK = curr[2];

                if (r == m - 1 && c == n - 1) {
                    return step;
                }

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    int newK = remainingK;

                    if (grid[nr][nc] == 1) {
                        if (remainingK == 0) {
                            continue;
                        }

                        newK--;
                    }

                    if (!visited[nr][nc][newK]) {
                        visited[nr][nc][newK] = true;
                        q.offer(new int[]{nr, nc, newK});
                    }
                }
            }

            step++;
        }

        return -1;
    }
}