//optimize
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        // (cummilativesum,count)
        map.put(0,1);
        int res=0;
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

// brute force 
// int res=0;
// for(int i=0;i<n;i++){
//     if(nums[i]==target){
//         nums[i]=1;
//     } else{
//         nums[i]=-1;
//     }
// }
// for(int i=1;i<n;i++){
//     nums[i]+=nums[i-1];
// }
// for(int i=0;i<n;i++){
//     for(int j=i;j<n;j++){
//         int sum=nums[j]-((i>0)?nums[i-1]:0);
//         if(sum>0){
//             res++;
//         }
//     }
// }
// return res;