class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0]!=1) arr[0]=1;
        int n=arr.length;
        if(n==1) return 1;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if((arr[i]-arr[i-1])>1){
                arr[i]=arr[i-1]+1;
            }
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}