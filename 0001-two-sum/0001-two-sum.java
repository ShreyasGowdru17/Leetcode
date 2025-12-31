class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set=new HashSet<>();
        int[] result=new int[2];
        int req=0;
        for(int i=0;i<nums.length;i++){
            int cur=target-nums[i];
            if(set.contains(cur)){
                result[0]=i;
                req=cur;
                break;
            }else{
                set.add(nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(req==nums[i]){
                result[1]=i;
                break;
            }
        }
        return result;
    }
}