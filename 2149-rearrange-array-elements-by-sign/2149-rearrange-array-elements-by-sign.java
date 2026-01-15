class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] array=new int[n];
        int posIndex=0;
        int negIndex=1;
        for(int num:nums){
            if(num>0 && posIndex<n){
                array[posIndex]=num;
                posIndex+=2;
            }else if(num<0 && negIndex<n){
                array[negIndex]=num;
                negIndex+=2;
            }
        }
        return array;
    }
}