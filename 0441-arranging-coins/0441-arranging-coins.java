class Solution {
    private long sumOfNaturalNumbers(long n){
        return (n*(n+1))/2;
    }
    public int arrangeCoins(int n) {
        int left=1;
        int right=n;
        while(left<=right){
            int mid=left+(right-left)/2;
            long coins=sumOfNaturalNumbers(mid);
            if(coins==n){
                return mid;
            }
            if(coins>n){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
}