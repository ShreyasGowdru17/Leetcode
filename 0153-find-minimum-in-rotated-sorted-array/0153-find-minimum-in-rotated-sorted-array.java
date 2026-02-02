class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int n=nums.length;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[low]<=nums[high]) break;
            else if(nums[mid]>nums[high]) low=mid+1;
            else high=mid-1;
        }
        return nums[low];
    }
}