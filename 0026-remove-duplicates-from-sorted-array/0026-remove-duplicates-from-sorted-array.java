class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int in=1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[in-1]){
                nums[in]=nums[i];
                in++;
            }
        }
        return in;
    }
}