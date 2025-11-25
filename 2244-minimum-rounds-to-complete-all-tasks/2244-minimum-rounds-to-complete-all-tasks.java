class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> freq=new HashMap<>();
        for(int task:tasks){
            freq.put(task,freq.getOrDefault(task,0)+1);
        }
        int round=0;
        for(int value:freq.values()){
                if(value<=1){
                    return -1;
                }
                if(value==2){
                    round++;
                } 
                if(value>=3){
                    round+=Math.ceil(value/3.0);
                }
            }
        if(round==0){
            return -1;
        }
        return round;
    }
}