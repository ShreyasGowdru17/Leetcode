class Solution {
    public int maximumScore(int[] nums, int k) {
       int n=nums.length;
       int i=k;
       int j=k;
       int curVal=nums[k];
       int maxVal=nums[k];
       while(i>0 || j<n-1){
            int leftVal=i>0?nums[i-1]:0;
            int rightVal=j<n-1?nums[j+1]:0;
            if(leftVal>rightVal){
                i--;
                curVal=Math.min(curVal,nums[i]);
            }else{
                j++;
                curVal=Math.min(curVal,nums[j]);
            }
            maxVal=Math.max(maxVal,curVal*(j-i+1));
       }
       return maxVal;
    }
}