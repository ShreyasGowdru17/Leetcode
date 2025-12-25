class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int count=0;
        int total=0;
        for(int num:apple){
            total+=num;
        } 
        int n=capacity.length;
        int i=n-1;  
        while(total>0 && i>=0){
            total-=capacity[i];
            count++;
            i--;
        }
        return count;
    }
}