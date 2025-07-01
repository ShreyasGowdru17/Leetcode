class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left=0;
        int right=0;
        int n=s.length();
        int cost=0;
        int maxLen=0;
        while(right<n){
            cost+=Math.abs((int) s.charAt(right)-(int) t.charAt(right));
            while(cost>maxCost){
                cost-=Math.abs((int) s.charAt(left)-(int) t.charAt(left));
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}