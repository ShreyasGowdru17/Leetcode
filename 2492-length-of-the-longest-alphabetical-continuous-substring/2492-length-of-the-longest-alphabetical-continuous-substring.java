class Solution {
    public int longestContinuousSubstring(String s) {
        int total=1;
        int maxTotal=1;
        for(int right=1;right<s.length();right++){
            if(s.charAt(right)==s.charAt(right-1)+1){
                total++;
            }else{
                total=1;
            }
            maxTotal=Math.max(total,maxTotal);
        }
        return maxTotal;
    }
}