class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0;
        int cnt2=0;
        int ele1=0;
        int ele2=0;
        for(int num:nums){
            if(cnt1==0 && ele2!=num){
                cnt1++;
                ele1=num;
            }else if(cnt2==0 && ele1!=num){
                cnt2++;
                ele2=num;
            }else if(ele1==num){
                cnt1++;
            }else if(ele2==num){
                cnt2++;
            }else {
                cnt1--;
                cnt2--;
            }
        }
            List<Integer> array=new ArrayList<>();
            cnt1=0;
            cnt2=0;
            int n=nums.length;
            for(int num:nums){
                if(ele1==num){
                    cnt1++;
                }else if(ele2==num){
                    cnt2++;
                }
            }
            if(cnt1>n/3){
                array.add(ele1);
            }
            if(cnt2>n/3){
                array.add(ele2);
            }
            return array;
    }
}