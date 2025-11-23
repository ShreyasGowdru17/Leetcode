class Solution {
    public int maximum69Number (int num) {
        int length=(int)Math.log10(num)+1;
        int count=length;
        int minIndex=-1;
        int number=num;
        int reverse=0;
        while(count>0){
            count--;
            int rem=number%10;
            reverse=reverse*10+rem;
            number=number/10;
            if(rem==6){
                minIndex=count;
            }
            
        }
        int ans=0;
        if(minIndex==-1) return num;
        count=length;
        int target=length-1-minIndex;
        while(count>0){
            count--;
            int rem=reverse%10;
            if(count==target) rem=9;
            ans=ans*10+rem;
            reverse=reverse/10;
        }
        return ans;
    }
}