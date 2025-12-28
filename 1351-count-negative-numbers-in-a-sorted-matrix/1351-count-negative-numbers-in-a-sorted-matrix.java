class Solution {
    private int lowerBound(int[] array){
        int n=array.length;
        int left=0;
        int right=n-1;
        int minIndex=n;
        while(left<=right){
            int mid=(left+right)/2;
            if(array[mid]>=0){
                left=mid+1;
            }else{
                right=mid-1;
                minIndex=mid;
            }
        }
        return n-minIndex;
    }
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int[] row:grid){
            count+=lowerBound(row);
        }
        return count;
    }
}