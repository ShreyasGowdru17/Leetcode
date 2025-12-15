class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        long max=0;
        for(int i=0;i<k;i++){
            int val=happiness[n-i-1]-i;
            if(val<=0) break;
            max+=val;
        }
        return max;
    }
}