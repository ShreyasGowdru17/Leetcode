class Solution {
    private int requiredHours(int[] piles,int numberOfBananas){
        int noOfHours=0;
        for(int pile:piles){
            noOfHours+=Math.ceil((double) pile/numberOfBananas);
        }
        return noOfHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=Arrays.stream(piles).max().getAsInt();
        int left=1;
        int right=maxPile;
        int ans=0;
        while(left <= right){
            int mid=(left + right)/2;
            int hoursNeeded=requiredHours(piles,mid);
            if(hoursNeeded <= h){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}