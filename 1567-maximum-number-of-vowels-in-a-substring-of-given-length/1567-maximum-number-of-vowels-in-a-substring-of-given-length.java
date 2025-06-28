class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set=new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int left=0;
        int right=0;
        int n=s.length();
        int count=0;
        int maxLen=Integer.MIN_VALUE;
        while(right<n){
            if(set.contains(s.charAt(right))){
                    count++;
            }
            if(right-left+1==k){
                maxLen=Math.max(maxLen,count);
                if(set.contains(s.charAt(left))){
                    count--;
                }
                left++;
            }
            right++;
        }
        return maxLen;
    }
}