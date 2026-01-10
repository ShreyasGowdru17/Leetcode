class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxLen=0;
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                count++;
            }else{
                count=0;
            }
            maxLen=Math.max(maxLen,count);
        }
        
        return maxLen;
    }
    
}