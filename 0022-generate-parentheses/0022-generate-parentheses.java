class Solution {
    private void generate(int left,int right,String answer,List<String> result){
        if(left==0 && right==0){
            result.add(answer);
            return;
        }
        if(left>0){
            generate(left-1,right,answer+"(",result);
        }
        if(right>left){
            generate(left,right-1,answer+")",result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        String answer="";
        generate(n,n,answer,result);
        return result;
    }
}