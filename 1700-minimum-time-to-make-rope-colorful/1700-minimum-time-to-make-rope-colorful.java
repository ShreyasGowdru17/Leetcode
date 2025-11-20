class Solution {
    public int minCost(String colors, int[] neededTime) {
        int prev=0;
        int prevMax=0;
        int time=0;
        int n=colors.length();
        for(int i=0;i<n;i++){
            if(i>0 && colors.charAt(i)!=colors.charAt(i-1)) prevMax=0;
            time+=Math.min(prevMax,neededTime[i]);
            prevMax=Math.max(prevMax,neededTime[i]);
        }
        return time;   
    }
}