class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] array=new int[10001];
        for(int i=0;i<banned.length;i++){
            array[banned[i]]=1;
        }
        long sum=0;
        int count=0;
        for(int i=1;i<=n;i++){
            if(array[i]==1) continue;
            sum+=i;
            if(sum>maxSum) return count;
            count++;
        }
        return count;
    }
}