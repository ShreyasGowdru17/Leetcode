class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int right=0;
        int left=0;
        int n=s.length();
        int maxLen=0;
        while(right<n){
            if(map.containsKey(s.charAt(right)) && map.get(s.charAt(right))>=left){
                left=map.get(s.charAt(right))+1;
            }
            map.put(s.charAt(right),right);
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}