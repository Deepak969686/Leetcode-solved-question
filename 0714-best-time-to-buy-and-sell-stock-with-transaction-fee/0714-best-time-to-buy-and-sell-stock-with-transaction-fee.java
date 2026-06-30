class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new int[n+1][2];
            for (int[] rows : dp) {
                Arrays.fill(rows, -1);
            }
        return solve(0, 1, prices,fee);
    }
        private int solve(int idx, int buy, int[] prices,int fee) {
        if ( idx >= n)
            return 0;
        if (dp[idx][buy]!= -1)
            return dp[idx][buy];
        if (buy == 1) {
            dp[idx][buy] = Math.max(-prices[idx] + solve(idx + 1, 0, prices,fee), solve(idx + 1, 1, prices,fee));
        } else {
            dp[idx][buy] = Math.max(prices[idx] + solve(idx + 1, 1, prices,fee)-fee, solve(idx + 1, 0, prices,fee));
        }
        return dp[idx][buy];
    } 
}