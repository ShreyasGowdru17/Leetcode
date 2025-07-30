class Solution {
    private Map<Character,String> map=new HashMap<>(Map.of(
        '2',"abc",
        '3',"def",
        '4',"ghi",
        '5',"jkl",
        '6',"mno",
        '7',"pqrs",
        '8',"tuv",
        '9',"wxyz"
    ));
    private void combinations(String digits,int index,String answer,List<String> result){
        if(index==digits.length()){
            result.add(answer);
            return;
        }

        String value=map.get(digits.charAt(index));
        for(int i=0;i<value.length();i++){
            answer+=value.charAt(i);
            combinations(digits,index+1,answer,result);
            answer=answer.substring(0,answer.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        combinations(digits,0,"",result);
        return result;
    }
}