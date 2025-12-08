class Solution {
    public int minOperations(int[] nums) {
     int count=0;
     Map<Integer,Integer> freq=new HashMap<>();
     for(int num:nums){
        freq.put(num,freq.getOrDefault(num,0)+1);
     }   
     for(int num:freq.values()){
            if(num==1) return -1;
            if(num%3 ==0) count+=num/3;
            else count+=(num/3)+1;
     }
     return count;
    }
}