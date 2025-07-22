class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue=new ArrayDeque<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty() && queue.peekFirst()<=i-k){
                queue.pollFirst();
            }
            while(!queue.isEmpty()&& nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if(i>=k-1){
                result.add(nums[queue.peekFirst()]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}