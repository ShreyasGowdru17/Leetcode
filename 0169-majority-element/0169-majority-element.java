class Solution {
    public int majorityElement(int[] nums) {
        int ele=0;
        int count=0;
        for(int num:nums){
            if(count==0){
                ele=num;
                count++;
            }else if(num==ele){
                count++;
            }else{
                count--;
            }
        }
        int maxCount=0;
        for(int num:nums){
            if(num==ele){
                maxCount++;
            }
        }
        int n=nums.length;
        if(maxCount>=n/2) return ele;
        return -1;
    }
}