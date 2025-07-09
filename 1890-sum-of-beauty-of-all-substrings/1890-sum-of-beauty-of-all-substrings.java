class Solution {
    public int beautySum(String s) {
        int total=0;
        for(int i=0;i<s.length();i++){
            int[] map=new int[26];
            for(int j=i;j<s.length();j++){
                int max=0;
                int min=Integer.MAX_VALUE;
                map[s.charAt(j)-'a']++;
                for(int value:map){
                    if(value>0){
                        max=Math.max(max,value);
                        min=Math.min(min,value);
                    }
                }
                 total+=max-min;
            }
           
        }
        return total;
    }
}