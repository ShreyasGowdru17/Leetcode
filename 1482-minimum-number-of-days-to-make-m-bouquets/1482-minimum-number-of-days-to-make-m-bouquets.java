class Solution {
    private boolean isPossible(int[] bloomDay,int k,int m,int noOfDays){
        int count=0;
        int bouquets=0;
        for(int days:bloomDay){

            if(days<=noOfDays){
                count++;

                if(count==k) {
                    count=0;
                    bouquets++;
                }
            }else{
                count=0;
            }
        }
        return bouquets>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(m*k>n) return -1;

        int min=Arrays.stream(bloomDay).min().getAsInt();
        int max=Arrays.stream(bloomDay).max().getAsInt();

        int left=min;
        int right=max;
        int ans=-1;

        while(left <= right){

            int mid=(left + right)/2;

            if(isPossible(bloomDay,k,m,mid)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}