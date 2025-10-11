class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     int low=0;
     int column=-1;
     int high=matrix.length-1;
     int n=matrix[0].length;
     while(low<=high){
        int mid=low+(high-low)/2;
        if(matrix[mid][0]<=target && matrix[mid][n-1]>=target){
            column=mid;
            break;
        }
        if(matrix[mid][0]>target ){
            high=mid-1;
        }else{
            low=mid+1;
        }
     } 
     if(column==-1){
        return false;
     }  
     System.out.print("Column found:"+column);
     int left=0;
     int right=n-1;
     while(left<=right){
        int mid=(left+right)/2;
        if(matrix[column][mid]==target){
            return true;
        }
        if(matrix[column][mid]>target){
            right=mid-1;
        }else{
            left=mid+1;
        }
     }
     return false;
    }
}