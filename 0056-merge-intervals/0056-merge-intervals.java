class Solution {
    public int[][] merge(int[][] intervals) {
        int m=intervals.length;
        int n=intervals[0].length;
        int[][] result=new int[m][2];
        int j=0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        result[0]=intervals[0];
        for(int i=1;i<m;i++){
            if(result[j][1]>=intervals[i][0]){
                result[j][1]=Math.max(result[j][1],intervals[i][1]);
            }else{
                j++;
                result[j]=intervals[i];
            }
        }
        return Arrays.copyOf(result,j+1);
    }
}