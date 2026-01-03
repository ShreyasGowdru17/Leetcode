class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       Set<Integer> set=new HashSet<>();
       Set<Integer> answer=new HashSet<>();
       int n1=nums1.length;
       int n2=nums2.length;
       for(int num:nums1){
            set.add(num);
       } 
       for(int num:nums2){
            if(set.contains(num)) answer.add(num);
       }
       int n=answer.size();
       int[] res=new int[n];
       int i=0;
       for(int num:answer){
            res[i++]=num;
       }
       return res;
    }
}