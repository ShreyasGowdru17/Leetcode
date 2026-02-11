class Solution {
    private int noOfDays(int[] weights,int  capacity){
        int currentLoad=0;
        int days=1;

        for(int weight:weights){

            if(currentLoad+weight>capacity){
                days++;
                currentLoad=weight;
            }else{
                currentLoad+=weight;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left=Arrays.stream(weights).max().getAsInt();
        int right=Arrays.stream(weights).sum();

        int ans=-1;
        while(left<=right){

            int mid=(left+right)/2;
            if(noOfDays(weights,mid)<=days){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}