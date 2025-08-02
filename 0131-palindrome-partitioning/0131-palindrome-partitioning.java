class Solution {
    private boolean palindrome(String s){
        if (s.length()==1) return true;
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    private void solve(String s,int index,List<String> answer,List<List<String>> result){
        if(index==s.length()){
            result.add(new ArrayList<>(answer));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(palindrome(s.substring(index,i+1))){
                answer.add(s.substring(index,i+1));
                solve(s,i+1,answer,result);
                answer.remove(answer.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> answer=new ArrayList<>();
        solve(s,0,answer,result);
        return result;
    }
}