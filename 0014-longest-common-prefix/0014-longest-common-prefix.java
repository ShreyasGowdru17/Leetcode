class Solution {
    public String longestCommonPrefix(String[] strs) {
       String prefix = strs[0];
       int n = prefix.length();
       StringBuilder sb = new StringBuilder();

       for( int i = 0;i < n;i++){
            for( String word : strs){
                int m=word.length();
                if(i>=m || prefix.charAt(i)!=word.charAt(i)) return sb.toString();
            }
            sb.append(prefix.charAt(i));
       }
       
       return sb.toString();
    }
}