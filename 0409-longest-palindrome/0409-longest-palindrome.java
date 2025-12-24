class Solution {
    public int longestPalindrome(String s) {
       Map<Character,Integer> freq=new HashMap<>();
       int n=s.length();
       for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
       } 
       int count=0;
       for(int value:freq.values()){
          if(value%2==0)count+=value;
          else count+=value-1;
       }
       return count<n?count+1:count;
    }
}