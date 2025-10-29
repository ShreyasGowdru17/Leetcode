class Solution {
    public int singleNumber(int[] nums) {
        int missing=0;
        for(int num:nums){
            missing=missing^num;
        }
        return missing;
    }
}