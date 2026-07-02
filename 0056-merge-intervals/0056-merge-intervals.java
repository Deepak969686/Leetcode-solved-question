class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ans=new ArrayList<>();
        for(int[] interval:intervals){
                // First interval OR no overlap
            if(ans.isEmpty() || interval[0]>ans.get(ans.size()-1)[1]){
                ans.add(interval);
            } else{
                // merge
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}



// class Solution {

//     public List<List<Integer>> merge(int[][] intervals) {

//         int n = intervals.length;

//         // Sort based on start time
//         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

//         List<List<Integer>> ans = new ArrayList<>();

//         for (int i = 0; i < n; i++) {

//             int start = intervals[i][0];
//             int end = intervals[i][1];

//             // Current interval is already covered
//             if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
//                 continue;
//             }

//             // Merge all overlapping intervals
//             for (int j = i + 1; j < n; j++) {

//                 if (intervals[j][0] <= end) {

//                     end = Math.max(end, intervals[j][1]);

//                 } else {
//                     break;
//                 }
//             }

//             ans.add(Arrays.asList(start, end));
//         }

//         return ans;
//     }
// }