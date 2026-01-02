class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
       for(int i=0;i<n-2;i++){
            if(nums[i+1]==nums[i]) return nums[i];
            if(nums[i+2]==nums[i]) return nums[i];
       }
       return nums[n-1];
    }
}