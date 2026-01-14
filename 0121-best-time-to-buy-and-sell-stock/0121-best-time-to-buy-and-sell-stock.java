class Solution {
    public int maxProfit(int[] prices) {
        int left=0;
        int right=1;
        int profit=0;
        int n=prices.length;
        while(right<n){
            if(prices[left]>prices[right]){
                left=right;
            }
            profit=Math.max(profit,prices[right]-prices[left]);
            right++;
        }
        return profit;
    }
}