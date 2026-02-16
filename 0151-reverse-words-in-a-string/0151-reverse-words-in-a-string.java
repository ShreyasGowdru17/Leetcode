class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = n-1;
        while(i >= 0){

            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }

            if(i < 0) break;

            int end = i;
            
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }

            String word = s.substring(i+1,end+1);

            if(! sb.isEmpty()){
                sb.append(" ");
            }

            sb.append(word);
        }

        return sb.toString();
    }
}