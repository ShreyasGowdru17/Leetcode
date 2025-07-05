class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s=strs[0];
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(String t:strs){
                if(i==t.length() || t.charAt(i)!=s.charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}