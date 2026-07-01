class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        // PriorityQueue<Integer> pq=new PriorityQueue<>();
        // for(int i=0;i<nums.length;i++){
        //     pq.offer(nums[i]);
        //     if(pq.size()>k){
        //         pq.poll();
        //     }
        // }
        // return pq.peek();

        // max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, (a, b) -> b - a);
        for (int num : nums) {
            maxHeap.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}