class Solution {
    int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int N = n;
        int M = r - l + 1;
        long[][][] dp = new long[N + 1][M + 1][2];
        // Base Case
        for (int prevval = 1; prevval <= M; prevval++) {
            dp[N][prevval][0] = 1;
            dp[N][prevval][1] = 1;
        }
        for (int i = N - 1; i >= 0; i--) {
            long[] prefix0 = new long[M + 1];
            long[] prefix1 = new long[M + 1];
            // Prefix Sum
            for (int prevval = 1; prevval <= M; prevval++) {
                prefix0[prevval] = (prefix0[prevval - 1] + dp[i + 1][prevval][0]) % MOD;
                prefix1[prevval] = (prefix1[prevval - 1] + dp[i + 1][prevval][1]) % MOD;
            }
            for (int prevval = 1; prevval <= M; prevval++) {
                // Increasing
                dp[i][prevval][1] =
                        (prefix0[M] - prefix0[prevval] + MOD) % MOD;

                // Decreasing
                dp[i][prevval][0] =
                        prefix1[prevval - 1];
            }
        }

        long res = 0;

        for (int startVal = 1; startVal <= M; startVal++) {

            res = (res + dp[1][startVal][1]) % MOD;

            res = (res + dp[1][startVal][0]) % MOD;
        }

        return (int) res;
    }
}

// rescusion+memoization(TLE)

// class Solution {
//     int MOD = 1_000_000_007;
//     int N, M;
//     int[][][] dp = new int[2001][2001][2];

//     public int zigZagArrays(int n, int l, int r) {
//         N = n;
//         M = r - l + 1;
//         int res = 0;
//         for (int[][] matrix : dp)
//             for (int[] rows : matrix)
//                 Arrays.fill(rows, -1);

//         for (int startval = 1; startval <= M; startval++) {
//             //increasing (1 means inreasing)
//             res = (res + solve(1, startval, 1)) % MOD;
//             // decreasing (0 means decreasing)
//             res = (res + solve(1, startval, 0)) % MOD;

//         }
//         return (int) res;
//     }

//     private int solve(int i, int prevval, int increasing) {
//         if (i == N)
//             return 1;
//         int res = 0;
//         if(dp[i][prevval][increasing]!=-1) return dp[i][prevval][increasing];
//         if (increasing == 1) {
//             for (int nextval = prevval + 1; nextval <= M; nextval++) {
//                 res = (res + solve(i + 1, nextval, 0)) % MOD;
//             }
//         } else {
//             for (int nextval = 1; nextval < prevval; nextval++) {
//                 res = (res + solve(i + 1, nextval, 1)) % MOD;
//             }
//         }
//         return dp[i][prevval][increasing]=res;
//     }
// }