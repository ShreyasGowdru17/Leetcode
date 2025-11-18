class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxIndex=0;
        for(int i=0;i<n-1;i++){
            maxIndex=Math.max(nums[i]+i,maxIndex);
            if(maxIndex<=i) return false;
        }
        return maxIndex>=n-1;
    }
}