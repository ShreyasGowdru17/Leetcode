class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int cur=0;
        int count=0;
        for(int j=2;j<nums.length;j++){
            if(nums[j]-nums[j-1]==nums[j-1]-nums[j-2]){
                cur++;
                count+=cur;
            } 
            else{
                cur=0;
            }
 
        }
        return count;
    }
}