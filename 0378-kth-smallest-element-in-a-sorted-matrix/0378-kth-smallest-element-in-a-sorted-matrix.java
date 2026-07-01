class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        // max heap

        // PriorityQueue<Integer> maxheap=new PriorityQueue<>(n,(a,b)->b-a);
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         maxheap.offer(matrix[i][j]);
        //         if(maxheap.size()>k){
        //             maxheap.poll();
        //         }
        //     }
        // }
        // return maxheap.peek();

        // min heap

        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                minheap.offer(matrix[i][j]);
            }
        }
        for(int i=0;i<k-1;i++){
            minheap.poll();
        }
        return minheap.peek();
    }
}