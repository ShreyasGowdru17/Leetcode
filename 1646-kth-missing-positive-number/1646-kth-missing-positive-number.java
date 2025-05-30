import java.util.Arrays;
class Solution {
    public int findMin(int[] arr){
        return Arrays.stream(arr).min().getAsInt();
    }

    public int findMax(int[] arr){
        return Arrays.stream(arr).max().getAsInt();
    }
    public int findKthPositive(int[] arr, int k) {
        int left=0;
        int right=arr.length-1;
        int n=arr.length;
        if(k<findMin(arr)){
            return k;
        }
        if(k>findMax(arr)-n){
            return k+n;
        }
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]-(mid+1)<k){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        int missing=arr[right]-(right+1);
        int required=arr[right]+(k-missing);
        return required;
    }
}