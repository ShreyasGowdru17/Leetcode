class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result=Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            int swaps=findSwaps(tops,bottoms,i);
            if(swaps!=-1){
                result=Math.min(result,swaps);
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
    private int findSwaps(int[] tops,int[] bottoms,int val){
        int topSwaps=0;
        int bottomSwaps=0;
        int n=tops.length;
        for(int i=0;i<n;i++){
            if(tops[i]!=val && bottoms[i]!= val) return -1;
            else if(tops[i]!=val) topSwaps++;
            else if(bottoms[i]!=val) bottomSwaps++;
        }
        return Math.min(topSwaps,bottomSwaps);
    }
}