class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        int[][] sortedPairs=new int[n][2];
        for(int i=0;i<n;i++){
            sortedPairs[i]=new int[]{i,score[i]};
        }
        Arrays.sort(sortedPairs,(x,y)->(y[1]-x[1]));

        String[] result=new String[n];
        for(int i=0;i<n;i++){
            if(i==0){
                result[sortedPairs[i][0]]="Gold Medal";
            }else if(i==1){
                result[sortedPairs[i][0]]="Silver Medal";
            }else if(i==2){
                 result[sortedPairs[i][0]]="Bronze Medal";
            }else{
                 result[sortedPairs[i][0]]=String.valueOf(i+1);
            }
        }
        return result;
    }
}