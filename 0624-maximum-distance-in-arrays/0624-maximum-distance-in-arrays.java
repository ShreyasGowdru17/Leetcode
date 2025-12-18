class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
      int min=arrays.get(0).get(0);
      int m=arrays.get(0).size();
      int max=arrays.get(0).get(m-1);
      int ans=0;
      int n=arrays.size();
      for(int i=1;i<n;i++){
        m=arrays.get(i).size();
        int curMax=arrays.get(i).get(m-1);
        int curMin=arrays.get(i).get(0);
        ans=Math.max(ans,Math.abs(curMax-min));
        ans=Math.max(ans,Math.abs(curMin-max));
        min=Math.min(min,curMin);
        max=Math.max(max,curMax);
      }
      return ans;
    }
}