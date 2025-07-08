class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map=Map.of(
            'I',1,
            'V',5,
            'X',10,
            'L',50,
            'C',100,
            'D',500,
            'M',1000
        );
        int value=0;
        int prev=0;
        for(int right=s.length()-1;right>=0;right--){
            char number=s.charAt(right);
            if(map.get(number)>=prev){
                value+=map.get(number);
            }
            else{
                value-=map.get(number);
            }
            prev=map.get(number);
        }
        return value;
    }
}