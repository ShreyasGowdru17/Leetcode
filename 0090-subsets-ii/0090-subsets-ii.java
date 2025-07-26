class Solution {
    
    private void subsequence(int[] nums,int start,List<List<Integer>> result,List<Integer> answer){
        
        result.add(new ArrayList<>(answer));
    
        for(int index=start;index<nums.length;index++){
            if(index>start && nums[index]==nums[index-1])continue;
            answer.add(nums[index]);
            subsequence(nums,index+1,result,answer);
            answer.remove(answer.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        subsequence(nums,0,result,new ArrayList<>());
        return result;
    }
}