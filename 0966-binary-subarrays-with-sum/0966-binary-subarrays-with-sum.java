class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        int left=0;
        int right=0;
        int n=nums.length;
        int total=0;
        int prefixZero=0;
        while(right<n){
           total+=nums[right];
           while(left!=right && (nums[left]==0|| total>goal)){
                if(nums[left]==0){
                    prefixZero++;
                }
                else{
                    prefixZero=0;
                }
                total-=nums[left];
                left++;
           }
           if(total==goal){
             count+=1+prefixZero;
           }
           right++;
        }
        return count;
        
    }
}