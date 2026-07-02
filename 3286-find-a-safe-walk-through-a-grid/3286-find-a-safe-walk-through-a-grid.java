class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] res=new int[m][n];
        for(int[] rows:res) Arrays.fill(rows,Integer.MAX_VALUE);
        Deque<int[]> dq = new ArrayDeque<>();
        res[0][0]=grid.get(0).get(0);
        dq.offerFirst(new int[]{0,0});
        while(!dq.isEmpty()){
            int[] cell=dq.pollFirst();
            int r=cell[0];
            int c=cell[1];
            for(int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr<0 || nc<0 || nr>=m || nc>=n) continue;
                if(res[nr][nc]>res[r][c]+grid.get(nr).get(nc)){
                    res[nr][nc]=res[r][c]+grid.get(nr).get(nc);
                    if(grid.get(nr).get(nc)==0){
                        dq.offerFirst(new int[]{nr,nc});
                    } else{
                        dq.offerLast(new int[]{nr,nc});
                    }
                }
            }
        }
        int x=res[m-1][n-1];
        return health-x>=1;
    }
}





// class Pair{
//     int row,col,health;
//     Pair(int r,int c,int h){
//         this.row=r;
//         this.col=c;
//         this.health=h;
//     }
// }
// class Solution {
//     public boolean findSafeWalk(List<List<Integer>> grid, int health) {
//         int m = grid.size();
//         int n = grid.get(0).size();
//         int starthealth=health-grid.get(0).get(0);
//         if(starthealth<1) return false;
//         int[][] besthealth=new int[m][n];
//         for(int[] rows:besthealth){
//         Arrays.fill(rows,-1);
//         }

//         PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.health-a.health);
//         besthealth[0][0]=starthealth;
//         int[][] dir=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
//         pq.offer(new Pair(0,0,starthealth));

//         while(!pq.isEmpty()){
//             Pair curr=pq.poll();
//             int rr=curr.row;
//             int cc=curr.col;
//             int hh=curr.health;
//             if(rr==m-1 && cc==n-1) return true;
//             for(int[] d:dir){
//                 int nr=rr+d[0];
//                 int nc=cc+d[1];
//                 if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
//                 int nh=hh;
//                 if(grid.get(nr).get(nc)==1) nh--;
//                 if(nh<1) continue;
//                 if(nh>besthealth[nr][nc]){
//                     besthealth[nr][nc]=nh;
//                     pq.offer(new Pair(nr,nc,nh));
//                 }

//             }
//         }
//         return false;
//     }
// }





// class Solution {
//     int m, n;
//     Boolean[][][] dp;
//     int[][] vis;
//     int[][] moves = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

//     public boolean findSafeWalk(List<List<Integer>> grid, int health) {
//          m = grid.size();
//          n = grid.get(0).size();
//         dp = new Boolean[m + 1][n + 1][health + 1];
//         vis = new int[m][n];
//         return solve(0, 0, grid, health);
//     }

//     private boolean solve(int r, int c, List<List<Integer>> grid, int health) {
//         if (grid.get(r).get(c) == 1)
//             health--;
//         if (health < 1)
//             return false;
//         if (r == m - 1 && c == n - 1)
//             return true;
//         if (dp[r][c][health] != null)
//             return dp[r][c][health];
//         vis[r][c] = 1;
//         for (int[] move : moves) {
//             int nr = r + move[0];
//             int nc = c + move[1];
//             if (nr >= 0 && nr < m &&
//                     nc >= 0 && nc < n &&
//                     vis[nr][nc] == 0) {
//                 if (solve(nr, nc, grid, health)) {
//                     vis[r][c] = 0;
//                     return dp[r][c][health] = true;
//                 }
//             }
//         }
//         vis[r][c] = 0;
//         return dp[r][c][health] = false;
//     }
// }





// class Solution {
//     int m, n;
//     Boolean[][][] dp;
//     int[][] vis;
//     int[][] moves = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

//     public boolean findSafeWalk(List<List<Integer>> grid, int health) {
//          m = grid.size();
//          n = grid.get(0).size();
//         dp = new Boolean[m + 1][n + 1][health + 1];
//         vis = new int[m][n];
//         return solve(0, 0, grid, health);
//     }

//     private boolean solve(int r, int c, List<List<Integer>> grid, int health) {
//         if (grid.get(r).get(c) == 1)
//             health--;
//         if (health < 1)
//             return false;
//         if (r == m - 1 && c == n - 1)
//             return true;
//         if (dp[r][c][health] != null)
//             return dp[r][c][health];
//         vis[r][c] = 1;
//         for (int[] move : moves) {
//             int nr = r + move[0];
//             int nc = c + move[1];
//             if (nr >= 0 && nr < m &&
//                     nc >= 0 && nc < n &&
//                     vis[nr][nc] == 0) {
//                 if (solve(nr, nc, grid, health)) {
//                     vis[r][c] = 0;
//                     return dp[r][c][health] = true;
//                 }
//             }
//         }
//         vis[r][c] = 0;
//         return dp[r][c][health] = false;
//     }
// }