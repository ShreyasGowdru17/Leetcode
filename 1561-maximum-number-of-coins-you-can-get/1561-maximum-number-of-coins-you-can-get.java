class Solution {
    public int maxCoins(int[] piles) {
        int maxCoins=0;
        int n=piles.length;
        Arrays.sort(piles);
        int i=0;
        int j=n-2;
        while(j>=0 && i<j){
            maxCoins+=piles[j];
            j-=2;
            i++;
        }
        return maxCoins;
    }
}