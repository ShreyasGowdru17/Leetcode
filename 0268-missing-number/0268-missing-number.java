class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int arraySum=Arrays.stream(nums).sum();
        int sum=(n*(n+1))/2;
        return sum-arraySum;
    }
}