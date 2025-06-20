class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int maxLen=0;
        int n=nums.length;
        while(right<n){
            if(nums[right]==0){
                k--;
                if(k<0){
                    while(nums[left]!=0 && left!=right){
                        left++;
                    }
                    left++;
                    k++;
                }
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}