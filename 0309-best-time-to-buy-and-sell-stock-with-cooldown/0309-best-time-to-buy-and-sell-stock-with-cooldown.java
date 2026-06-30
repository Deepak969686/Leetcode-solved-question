class Solution {
    int n;
    int[][][] dp;

    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n+1][2][n+1];
        for (int[][] matrix : dp) {
            for (int[] rows : matrix) {
                Arrays.fill(rows, -1);
            }
        }
        return solve(0, 1, n, prices);
    }

    private int solve(int idx, int buy, int cap, int[] prices) {
        if (cap == 0 || idx >= n)
            return 0;
        if (dp[idx][buy][cap] != -1)
            return dp[idx][buy][cap];
        if (buy == 1) {
            dp[idx][buy][cap] = Math.max(-prices[idx] + solve(idx + 1, 0, cap, prices), solve(idx + 1, 1, cap, prices));
        } else {
            dp[idx][buy][cap] = Math.max(prices[idx] + solve(idx + 2, 1, cap, prices), solve(idx + 1, 0, cap, prices));
        }
        return dp[idx][buy][cap];
    }
}