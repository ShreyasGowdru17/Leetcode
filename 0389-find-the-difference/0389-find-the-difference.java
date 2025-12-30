class Solution {
    public char findTheDifference(String s, String t) {
        int count1=0;
        for(int i=0;i<s.length();i++){
            count1+=s.charAt(i)-'a';
        }
        int count2=0;
        for(int i=0;i<t.length();i++){
            count2+=t.charAt(i)-'a';
        }
        return (char)('a'+(count2-count1));
    }
}