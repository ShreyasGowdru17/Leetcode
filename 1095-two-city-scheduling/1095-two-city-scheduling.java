class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->(b[0]-b[1])-(a[0]-a[1]));
        int cost=0;
        int n=costs.length;
        for(int i=0;i<costs.length;i++){
            cost+=i<n/2?costs[i][1]:costs[i][0];
        }
        return cost;
    }
}