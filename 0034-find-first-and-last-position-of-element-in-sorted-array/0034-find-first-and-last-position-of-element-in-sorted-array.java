class Solution {
    public int[] searchRange(int[] nums, int target) {
        // [5,7,7,8,8,10];
        //  0 1 2 3 4 5
        // l=0 h=5
        // mid=2 target=8
        // arr[mid]<target l=3 mid=4
        // arr[mid]>=target h=3 start=3 mid=3
        // arr[mid]>=target h=2 start=2

        // [5,7,7,8,8,10] target =8
        //  0 1 2 3 4 5
        // l=0 h=5 mid=2 end=-1
        // arr[mid]<target l=3 h=5 mid=4 
        // arr[mid]==target end=4 l=5 h=5 mid=5
        // arr[mid]>target l=4 h=5 
        int n=nums.length;
        int low=0;
        int high=n-1;
        int[] ans={-1,-1};
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=target){
                if(nums[mid]==target) ans[0]=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        low=0;
        high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<=target){
                if(nums[mid]==target) ans[1]=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}