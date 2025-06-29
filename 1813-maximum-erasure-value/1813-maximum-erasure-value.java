class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left=0;
        int right=0;
        int n=nums.length;
        int maxSum=Integer.MIN_VALUE;
        int total=0;
        Set<Integer> set=new HashSet<>();
        while(right<n){
            while(set.contains(nums[right])){
                    set.remove(nums[left]);
                    total-=nums[left];
                    left++;
            }
            total+=nums[right];
            set.add(nums[right]);
            maxSum=Math.max(maxSum,total);
            right++;
        }
        return maxSum;
    }
}