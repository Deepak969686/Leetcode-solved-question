class DisjointSet{
    int[] parent;
    int[] size;
    DisjointSet(int n){
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public void unionBySize(int u,int v){
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
    public int findUPar(int node){
        if(node==parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet dsu=new DisjointSet(n);
        Map<String,Integer> emailmap=new HashMap<>();
        // Map emails to account indices and union connected accounts
        for(int i=0;i<n;i++){
            List<String> acc = accounts.get(i);
            for(int j=1;j<acc.size();j++){
                String email=acc.get(j);
                if(!emailmap.containsKey(email)){
                    emailmap.put(email,i);
                } else{
                    dsu.unionBySize(i,emailmap.get(email));
                }
            }
        }
        // Group emails by their ultimate parent index
        ArrayList<String>[] mergedmail=new ArrayList[n];
        for(int i=0;i<n;i++) mergedmail[i]=new ArrayList<>();
        for(Map.Entry<String,Integer> it:emailmap.entrySet()){
            int node=dsu.findUPar(it.getValue());
            mergedmail[node].add(it.getKey());
        }
        // Format the result: Sort emails and add account names
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedmail[i].isEmpty()) continue;
            Collections.sort(mergedmail[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedmail[i]);
            res.add(temp);
        }
        return res;
    }
}