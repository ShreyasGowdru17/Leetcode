class Solution {

    private List<Integer> answer=new ArrayList<>();
    private Set<List<Integer>> result=new HashSet<>();
    private void backtrack(int[] nums,int index,List<Integer> answer,boolean[] used){
        if(answer.size()==nums.length){
            result.add(new ArrayList<>(answer));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;

            used[i]=true;
            answer.add(nums[i]);
            backtrack(nums,index+1,answer,used);
            answer.remove(answer.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
      boolean[] used=new boolean[nums.length];
      backtrack(nums,0,answer,used);
      return new ArrayList<>(result);
    }
}