class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long sum=0;
        long squareSum=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                long val=grid[i][j];
                sum+=val;
                squareSum+=val*val;
            }
        }
        long a=(long)n*m;
        long actualSum=(a)*(a+1)/2;
        long squareActualSum=(a)*(a+1)*(2*a+1)/6;

        long squareDiff=squareSum-squareActualSum;
        long sumDiff=sum-actualSum;

        long rem=squareDiff/sumDiff;
        
        long repeatedNumber=(sumDiff+rem)/2;
        long missing=rem-repeatedNumber;
        int[] result={(int)repeatedNumber,(int)missing};
        return result;
    }
}