class Solution {
    public void backtrack(int num,int n,Set<Integer> visited,List<Integer> result){
        if(result.size()==(1<<n)) return;

        for(int i=0;i<n;i++){
            int next=num^(1<<i);
            if(!visited.contains(next)){
                result.add(next);
                visited.add(next);
                backtrack(next,n,visited,result);
                if(result.size()==(1<<n)) return;
            }
        }
    }
    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        result.add(0);
        visited.add(0);
        backtrack(0,n,visited,result);
        return result;
    }
}