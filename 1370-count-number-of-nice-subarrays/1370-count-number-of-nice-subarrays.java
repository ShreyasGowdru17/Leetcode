class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left=0;
        int right=0;
        int count=0;
        int oddNo=0;
        int evenNo=0;
        int n=nums.length;
        while(right<n){
            if(nums[right]%2!=0){
                oddNo++;
            }
            while(left<right && (nums[left]%2==0 || oddNo>k)){
                if(nums[left]%2==0){
                    evenNo++;
                }
                else{
                    evenNo=0;
                    oddNo--;
                }
                left++;
            }

            if(k==oddNo){
                count+=1+(evenNo);
            }
            right++;
        }
        return count;
    }
}