class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        // (cummilativesum,count)
        map.put(0,1);
        long res=0;
        int validleftpoints=0;
        int cumsum=0;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                validleftpoints+=map.getOrDefault(cumsum, 0);
                cumsum++;
            } else{
                cumsum--;
                validleftpoints-=map.getOrDefault(cumsum, 0);
            }
            map.put(cumsum,map.getOrDefault(cumsum,0)+1);
            res+=validleftpoints;
        }
        return res;
    }
}