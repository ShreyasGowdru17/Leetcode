class Solution {
    public String longestPalindrome(String s) {
        
        int start = 0; 
        int end = 0;

        int n = s.length();

        for(int i = 0;i < n;i++){

            int oddLen = expand(s,i,i);
            int evenLen = expand(s,i,i+1);
            int len = Math.max(oddLen,evenLen);

            if(len > end - start){
                start = i -(len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start ,end + 1);
    }

    private int expand(String s ,int left ,int right){
        int n = s.length();
        while( left >=0 && right < n){
            if (s.charAt(left) != s.charAt(right)) break;
            left --;
            right ++;
        }

        return right - left - 1;
    }
}