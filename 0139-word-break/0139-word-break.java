class Solution {
    private boolean explore(int index,Set set,String s,Boolean[] memo){
        if(index==s.length()) return true;

        if(memo[index]!=null) return memo[index];

        for(int i=index;i<s.length();i++){
            String substring=s.substring(index,i+1);
            if(set.contains(substring)){
                if(explore(i+1,set,s,memo)){
                    memo[index]=true;
                    return true;
                };
            }
        }
        memo[index]=false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        Boolean[] memo=new Boolean[s.length()];
        return explore(0,set,s,memo);
    }
}