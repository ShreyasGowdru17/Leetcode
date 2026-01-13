class Solution {
    public int maxSubArray(int[] nums) {
        int curMax=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            curMax+=num;
            if(max<curMax){
                max=curMax;
            }
            if(curMax<0){
                curMax=0;
            }
        }

        return max;
    }
}