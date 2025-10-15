class Solution {
    private int lowerBound(int[] nums){
        int left=0;
        int right=nums.length-1;
        int n=nums.length;
        int firstNegative=n;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<0){
                firstNegative=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return n-firstNegative;
    }
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int count=0;
        for(int i=0;i<n;i++){
            count+=lowerBound(grid[i]);
        }
        return count;
    }
}