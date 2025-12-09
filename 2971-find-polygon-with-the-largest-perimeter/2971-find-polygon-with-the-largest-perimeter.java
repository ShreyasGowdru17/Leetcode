class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        long curSum=0L;
        long ans=-1L;
        for(int i=0;i<n;i++){
            if(nums[i]<curSum){
                ans=curSum+nums[i];
            }
            curSum+=nums[i];
        }
        return ans;
    }
}