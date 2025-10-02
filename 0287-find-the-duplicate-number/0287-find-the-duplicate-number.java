class Solution {
    private int greaterThanMid(int[] nums,int mid){
        int count=0;
        for(int element:nums){
            if(element<=mid) count++;
        }
        return count;
    }
    public int findDuplicate(int[] nums) {
        int low=1;
        int high=nums.length;
        while(low<=high){
            int mid=(low+high)/2;
            int count=greaterThanMid(nums,mid);
            if(count>mid){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}