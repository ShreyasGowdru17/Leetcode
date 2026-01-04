class Solution {
    private int prime(int num){
        int res=1+num;
        int count=2;
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                int d1=i;
                int d2=num/i;
                if(d1==d2) return -1;

                res+=d1+d2;
                count+=2;
                if(count>4) return -1;
            }
        }
        if(count==4) return res;
        return -1;
    }
    public int sumFourDivisors(int[] nums) {
        int res=0;
        for(int num:nums){
            int ans=prime(num);
            if(ans!=-1) res+=ans;
        }
        return res;
    }
}