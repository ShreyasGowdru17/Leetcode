class Solution {
    private void swap(int[] nums,int start,int index){
        int temp=nums[start];
        nums[start]=nums[index];
        nums[index]=temp;
    }
    private void permutation(int[] nums,int start,List<List<Integer>> result){
        if(start==nums.length){
            List<Integer> answer=new ArrayList<>();
            for(int num:nums){
                answer.add(num);
            }
            result.add(answer);
            return;
        }
        for(int index=start;index<nums.length;index++){
            swap(nums,start,index);
            permutation(nums,start+1,result);
            swap(nums,start,index);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        permutation(nums,0,result);
        return result;
    }
}