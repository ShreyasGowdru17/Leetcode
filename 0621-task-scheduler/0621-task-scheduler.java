class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0){
            return tasks.length;
        }
        int[] freq=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        Arrays.sort(freq);
        int maxFreq=freq[25];
        int slots=maxFreq-1;
        int idleSlots=slots*n;
        for(int i=24;i>=0;i--){
            idleSlots-=Math.min(freq[i],slots);
        }
        if(idleSlots>0){
            return tasks.length+idleSlots;
        }
        return tasks.length;
    }
}