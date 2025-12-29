class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        int min=Integer.MAX_VALUE;
        for(int num:nums2){
            if(set.contains(num)){
                min=Math.min(num,min);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
        
    }
}