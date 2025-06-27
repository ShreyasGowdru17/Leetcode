class Solution {
    public double findMaxAverage(int[] nums, int k) {
       if(nums.length==1) return nums[0];
       int left=0;
       int right=k-1;
       double total=0;
       double maxAvg=Double.NEGATIVE_INFINITY;
       int n=nums.length;
       for(int i=0;i<k-1;i++){
            total+=nums[i];
       } 
        while(right<n){
            total+=nums[right];
            maxAvg=Math.max(total/k,maxAvg);
            total-=nums[left];
            left++;
            right++;
        }
        return maxAvg;
    }
}