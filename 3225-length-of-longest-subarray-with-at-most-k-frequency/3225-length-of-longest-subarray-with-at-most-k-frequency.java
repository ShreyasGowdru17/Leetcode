class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left=0;
        int right=0;
        int n=nums.length;
        int maxLen=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right])>k){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}