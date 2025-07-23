class Solution {
    public int subsequence(int[] nums,int index,int target,int total){
        if(nums.length==index){
            return total==target?1:0;
        }
        int add=subsequence(nums,index+1,target,total+nums[index]);
        int sub=subsequence(nums,index+1,target,total-nums[index]);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int count=subsequence(nums,0,target,0);
        return count;
    }
}