class Solution {
    private List<Integer> answer=new ArrayList<>();
    private List<List<Integer>> result=new ArrayList<>();
    private void backtrack(int n,int k,int num){
        if(answer.size()==k){
            result.add(new ArrayList<>(answer));
            return;
        }

        for(int i=num;i<=n;i++){
            answer.add(i);
            backtrack(n,k,i+1);
            answer.remove(answer.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1);
        return result;
    }
}