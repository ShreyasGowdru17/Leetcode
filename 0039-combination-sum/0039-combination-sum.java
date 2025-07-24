class Solution {
    private void combination(int[] candidates,int index,int target,int total,List<Integer> answer,List<List<Integer>> result){
        if(target==total){
            result.add(new ArrayList<>(answer));
            return;
        }
        if(total>target){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            answer.add(candidates[i]);
            combination(candidates,i,target,total+candidates[i],answer,result);
            answer.remove(answer.size()-1);
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        combination(candidates,0,target,0,new ArrayList<>(),result);
        return result;
    }
}