class Solution {
    int m, n;
    Boolean[][][] dp;
    int[][] vis;
    int[][] moves = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
         m = grid.size();
         n = grid.get(0).size();
        dp = new Boolean[m + 1][n + 1][health + 1];
        vis = new int[m][n];
        return solve(0, 0, grid, health);
    }

    private boolean solve(int r, int c, List<List<Integer>> grid, int health) {
        if (grid.get(r).get(c) == 1)
            health--;
        if (health < 1)
            return false;
        if (r == m - 1 && c == n - 1)
            return true;
        if (dp[r][c][health] != null)
            return dp[r][c][health];
        vis[r][c] = 1;
        for (int[] move : moves) {
            int nr = r + move[0];
            int nc = c + move[1];
            if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    vis[nr][nc] == 0) {
                if (solve(nr, nc, grid, health)) {
                    vis[r][c] = 0;
                    return dp[r][c][health] = true;
                }
            }
        }
        vis[r][c] = 0;
        return dp[r][c][health] = false;
    }
}