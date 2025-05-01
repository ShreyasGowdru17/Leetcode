class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int pivot;
        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        pivot=low;
        low=0;
        high=nums.length-1;
        if(nums[pivot]==target){
            return pivot;
        }
        if (target>nums[pivot] && target<=nums[high]){
            low=pivot+1;
        }
        else{
            high=pivot-1;
        }

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}