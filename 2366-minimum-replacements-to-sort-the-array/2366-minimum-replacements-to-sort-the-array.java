class Solution {
    public long minimumReplacement(int[] nums) {
        int n=nums.length;
        long totalParts=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                continue;
            }
            long parts=(nums[i])/nums[i+1];
            if(nums[i]%nums[i+1]!=0){
                parts++;
            }
            nums[i]=nums[i]/(int)parts;
            totalParts+=parts-1;

        }
        return totalParts;
    }
}