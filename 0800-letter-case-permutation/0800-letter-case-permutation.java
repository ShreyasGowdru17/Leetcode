class Solution {
    private void permutations(String s,int index,StringBuilder sb,List<String> result){
        if(index==s.length()){
            result.add(sb.toString());
            return;
        }
        if(Character.isLetter(s.charAt(index))){
            permutations(s,index+1,sb.append(Character.toLowerCase(s.charAt(index))),result);
            sb.deleteCharAt(sb.length()-1);
            permutations(s,index+1,sb.append(Character.toUpperCase(s.charAt(index))),result);
            sb.deleteCharAt(sb.length()-1);
            
        }
        else{
            permutations(s,index+1,sb.append(s.charAt(index)),result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> result=new ArrayList<>();
        permutations(s,0,new StringBuilder(),result);
        return result;
    }
}