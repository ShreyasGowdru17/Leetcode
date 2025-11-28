class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n=growTime.length;
        int[][] array=new int[n][2];
        for(int i=0;i<n;i++){
            array[i][0]=plantTime[i];
            array[i][1]=growTime[i];
        }
        Arrays.sort(array,(a,b)->b[1]-a[1]);
        int prevPlantDays=0;
        int maxBloomDays=0;
        for(int[] pair:array){
            prevPlantDays+=pair[0];
            maxBloomDays=Math.max(prevPlantDays+pair[1],maxBloomDays);
        }
        return maxBloomDays;
    }
}