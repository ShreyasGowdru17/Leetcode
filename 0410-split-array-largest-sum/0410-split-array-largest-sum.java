class Solution {
    private boolean partition(int[] nums,int k,int maxValue){
        int curSum = 0;
        int parts=1;

        for(int num : nums){
            if(curSum + num <= maxValue){
                curSum += num;
            }else{
                parts++;
                curSum = num;
            }
        }
        return parts>k;

    }
    public int splitArray(int[] nums, int k) {

        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        int ans = -1;

        while(left <= right){

            int mid = ( left + right)/2;
            if(partition(nums,k,mid)){
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }
        
        return left;
    }
}