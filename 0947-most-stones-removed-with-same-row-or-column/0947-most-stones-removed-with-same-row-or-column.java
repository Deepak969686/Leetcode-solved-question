class DisjointSet{
    int[] parent;
    int[] size;
    DisjointSet(int n){
        parent=new int[n+1];
        size=new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUPar(int node){
        if(node==parent[node]) return node;
        return parent[node]=findUPar(parent[node]);
    }
    public void UnionBySize(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return;
        if(size[ulp_u]<size[ulp_v]){
            parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        } else{
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];            
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    ds.UnionBySize(i,j);
                }
            }
        }  
        int len=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i) len+=ds.size[i]-1;
        }
        return len;
    }
}