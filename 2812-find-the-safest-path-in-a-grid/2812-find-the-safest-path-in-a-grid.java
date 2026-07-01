class Solution {
    int n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // 1.precalculate the manhatten distance of every cell from theif cell
        // 2. binary search on safeness factor b/w lower 1 to max infinie and find mid 
        // 3. apply bfs and check all the cells sf >=mid
        
        // step1
        n=grid.size();
        int[][] distNearestThief=new int[n][n];
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][n];

        // push all cells in queue where theives are present
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    q.add(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] curr=q.poll();
                int curr_i=curr[0];
                int curr_j=curr[1];
                distNearestThief[curr_i][curr_j] = level;
                for(int[] dir:directions){
                    int new_i=curr_i+dir[0];
                    int new_j=curr_j+dir[1];
                    if(new_i<0 || new_i>=n || new_j<0 || new_j>=n || vis[new_i][new_j]) continue;
                    q.add(new int[]{new_i,new_j});
                    vis[new_i][new_j]=true;
                }
            }
            level++;
        }

        // step 2
        int l=0;
        int r=400;
        int res=0;
        while(l<=r){
            int mid_sf=l+(r-l)/2;
            if(check(distNearestThief, mid_sf)){
                res=mid_sf;
                l=mid_sf+1;
            } else{
                r=mid_sf-1;
            }
        }
        return res;
    }
    // step 3
    boolean check(int[][] distNearestThief,int sf){
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][n];
        q.add(new int[]{0,0});
        vis[0][0]=true;
        if(distNearestThief[0][0] < sf) return false;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int curr_i=curr[0];
            int curr_j=curr[1];
            if(curr_i==n-1 && curr_j==n-1) return true;
            for(int[] dir:directions){
                int new_i=curr_i+dir[0];
                int new_j=curr_j+dir[1];
                if(new_i>=0 && new_i<n && new_j>=0 && new_j<n && !vis[new_i][new_j]){
                    if(distNearestThief[new_i][new_j] < sf) continue;
                    q.add(new int[]{new_i,new_j});
                    vis[new_i][new_j]=true;
                }
            }
        }
        return false;
    }
}