class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int firstPositive=n;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>0){
                firstPositive=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        left=0;
        right=n-1;
        int lastNegative=-1;
         while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<0){
               lastNegative=mid;
               left=mid+1; 
            }else{
                right=mid-1;
            }
        }
        int countPositive=n-firstPositive;
        int countNegative=lastNegative+1;
        return Math.max(countPositive,countNegative);
    }
}