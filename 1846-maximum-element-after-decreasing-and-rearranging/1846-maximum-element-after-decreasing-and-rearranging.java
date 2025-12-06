class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
       Arrays.sort(arr);
       int prev=1;
       int n=arr.length;
       for(int i=1;i<n;i++){
            if(Math.abs(prev-arr[i])>1){
                prev=prev+1;
            }else{
                prev=arr[i];
            }
       } 
       return prev;
    }
}