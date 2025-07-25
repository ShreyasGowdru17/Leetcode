class Solution {
    private void combination(int[] candidates,int start,int target,List<Integer> answer,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(answer));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i> start && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) return;

            answer.add(candidates[i]);
            combination(candidates,i+1,target-candidates[i],answer,result);
            answer.remove(answer.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates,0,target,new ArrayList<>(),result);
        return result;
    }
}