class Solution {
    private void subsequence(int[] nums,int index,List<List<Integer>> result,List<Integer> answer){
        if(index>=nums.length){
            result.add(new ArrayList<>(answer));
            return;
        }
        answer.add(nums[index]);
        subsequence(nums,index+1,result,answer);
        answer.remove(answer.size()-1);
        subsequence(nums,index+1,result,answer);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        subsequence(nums,0,result,new ArrayList<>());
        return result;
    }
}