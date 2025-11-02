class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>(); 
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=n-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    result.add(new ArrayList<>(List.of(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) left++;

                }else if(nums[left]+nums[right]+nums[i]>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}