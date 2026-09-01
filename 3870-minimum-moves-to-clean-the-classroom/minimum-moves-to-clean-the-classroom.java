import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        char[][] grid = new char[m][n];

        int sr = 0;
        int sc = 0;

        // litterId[r][c] = unique ID of L
        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;

        // Build grid and assign IDs to L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                grid[i][j] = classroom[i].charAt(j);

                if (grid[i][j] == 'S') {
                    sr = i;
                    sc = j;
                }

                if (grid[i][j] == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int targetMask = (1 << litterCount) - 1;

        // State:
        // [row, col, remainingEnergy, mask]
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr, sc, energy, 0});

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        visited[sr][sc][energy][0] = true;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int e = curr[2];
                int mask = curr[3];

                // All litter collected
                if (mask == targetMask) {
                    return moves;
                }

                // Cannot move
                if (e == 0) {
                    continue;
                }

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Boundary
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    // Wall
                    if (grid[nr][nc] == 'X') {
                        continue;
                    }

                    int newEnergy = e - 1;
                    int newMask = mask;

                    // Litter
                    if (grid[nr][nc] == 'L') {

                        int id = litterId[nr][nc];

                        newMask |= (1 << id);
                    }

                    // Recharge
                    if (grid[nr][nc] == 'R') {
                        newEnergy = energy;
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.offer(new int[]{
                            nr,
                            nc,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}