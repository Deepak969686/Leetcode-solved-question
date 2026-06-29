class Solution {
    int n;
    int[][][] dp;
    public int maxProfit(int[] prices) {
        n=prices.length;
        dp=new int[n][2][3];
        for(int[][] matrix:dp){
            for(int[] rows:matrix){
                Arrays.fill(rows,-1);
            }
        }
        //(index,buy,cap,prices)
        return solve(0,1,2,prices);
    }
    private int solve(int idx,int buy,int cap,int[] prices){
        if(idx==n || cap==0) return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        if(buy==1){
            return dp[idx][buy][cap]=Math.max(-prices[idx]+solve(idx+1,0,cap,prices),solve(idx+1,1,cap,prices));
        } else {
            return dp[idx][buy][cap]=Math.max(prices[idx]+solve(idx+1,1,cap-1,prices),solve(idx+1,0,cap,prices));
        }
    }
}

// recursion but TLE
// class Solution {
//     public int maxProfit(int[] prices) {
//         //(index,buy,cap,prices)
//         return solve(0,1,2,prices);
//     }
//     private int solve(int idx,int buy,int cap,int[] prices){
//         if(idx==prices.length || cap==0) return 0;
//         if(buy==1){
//             return Math.max(-prices[idx]+solve(idx+1,0,cap,prices),solve(idx+1,1,cap,prices));
//         } else {
//             return Math.max(prices[idx]+solve(idx+1,1,cap-1,prices),solve(idx+1,0,cap,prices));
//         }
//     }
// }