class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int change=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                change=i;
                break;
            }
        }

        if(change==-1){
            int i=0;
            int j=n-1;
            while(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
            return;
        }
        for(int i=n-1;i>change;i--){
            if(nums[i]>nums[change]){
                int temp=nums[i];
                nums[i]=nums[change];
                nums[change]=temp;
                break;
            }
        }

        int i=change+1;
        int j=n-1;
        while(i<j){
        int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}