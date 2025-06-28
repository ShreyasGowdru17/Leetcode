class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left=0;
        int right=0;
        int n=blocks.length();
        int count=0;
        int minRecoloring=Integer.MAX_VALUE;
        while(right<n){

            if(blocks.charAt(right)=='W'){
                count++;
            }
            if(right-left+1==k){
                minRecoloring=Math.min(minRecoloring,count);
                if(blocks.charAt(left)=='W'){
                    count--;
                }
                left++;
            }
            right++;
        }
        return minRecoloring;  
    }
}