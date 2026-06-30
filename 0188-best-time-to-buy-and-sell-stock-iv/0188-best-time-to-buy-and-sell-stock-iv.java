class Solution {
    int n;
    int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        n=prices.length;
        dp=new int[n+1][2][k+1];
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy==1){
                        dp[idx][buy][cap]=Math.max(-prices[idx]+dp[idx+1][0][cap],dp[idx+1][1][cap]);
                    } else{
                        dp[idx][buy][cap]=Math.max(prices[idx]+dp[idx+1][1][cap-1],dp[idx+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}

// Memoization

// class Solution {
//     int n;
//     int[][][] dp;

//     public int maxProfit(int k, int[] prices) {
//         n = prices.length;
//         dp = new int[n][2][k+1];
//         for (int[][] matrix : dp) {
//             for (int[] rows : matrix) {
//                 Arrays.fill(rows, -1);
//             }
//         }
//         //(index,buy,cap,prices)
//         return solve(0, 1, k, prices);
//     }

//     private int solve(int idx, int buy, int cap, int[] prices) {
//         if (idx == n || cap == 0)
//             return 0;
//         if (dp[idx][buy][cap] != -1)
//             return dp[idx][buy][cap];
//         if (buy == 1) {
//             return dp[idx][buy][cap] = Math.max(-prices[idx] + solve(idx + 1, 0, cap, prices),
//                     solve(idx + 1, 1, cap, prices));
//         } else {
//             return dp[idx][buy][cap] = Math.max(prices[idx] + solve(idx + 1, 1, cap - 1, prices),
//                     solve(idx + 1, 0, cap, prices));
//         }
//     }
// }