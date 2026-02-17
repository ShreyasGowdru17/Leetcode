class Solution {
    public String largestOddNumber(String num) {
        int index = -1;
        int n = num.length();
        for(int i = n-1 ; i >= 0 ; i--){
            if((num.charAt(i) - '0') %2 == 1){
                index=i;
                break;
            }
        }

        if(index == -1) return "";

        int i = 0;
        while( i <= index && num.charAt(i) == '0') i++;

        return num.substring(i,index+1);
    }
}