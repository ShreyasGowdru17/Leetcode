class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int num:nums){
            minHeap.offer(num);
        }
        int[] result=new int[nums.length];
        int i=0;
        while(!minHeap.isEmpty()){
            result[i++]=minHeap.poll();
        }
        return result;
    }
}