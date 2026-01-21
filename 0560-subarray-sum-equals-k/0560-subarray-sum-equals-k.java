class Solution {
    public int subarraySum(int[] nums, int k) {
      int prefixSum=0;
      Map<Integer,Integer> map=new HashMap<>();
      map.put(0,1);
      int count=0;
      for(int num:nums){
            prefixSum+=num;
            int rem=prefixSum-k;
            count+=map.getOrDefault(rem,0);
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
      }  
      return count;
    }
}