class Solution {
    private boolean sumOfDivisor(int[] nums,int threshold,int divisor){
        int sum=0;

        for(int num:nums){
            sum+=(int) Math.ceil((double)num/divisor);
        }

        return sum<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        
        int n=nums.length;
        int left=1;
        int right=Arrays.stream(nums).max().getAsInt();

        int ans=0;

        while(left <= right){

            int mid=(left + right)/2;

            if(sumOfDivisor(nums,threshold,mid)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}