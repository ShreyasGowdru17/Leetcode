class Solution {
    public int noOfSplits(int[] nums,int k,int mid){
        int splits=1;
        int largest=0;
        for(int i=0;i<nums.length;i++){
            if(largest+nums[i]<=mid){
                largest+=nums[i];
            }
            else{
                splits++;
                largest=nums[i];
            }
        }
        return splits;
    }
    public int splitArray(int[] nums, int k) {
        int left=Arrays.stream(nums).max().getAsInt();
        int right=Arrays.stream(nums).sum();
        int ans=Integer.MAX_VALUE;
        while(left<=right){
            int mid=(left+right)/2;
            int splits=noOfSplits(nums,k,mid);
            if(splits<=k){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}