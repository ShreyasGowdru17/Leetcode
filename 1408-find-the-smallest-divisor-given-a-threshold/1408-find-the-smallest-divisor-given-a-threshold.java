import java.util.Arrays;
class Solution {
    public int findMax(int[] nums){
        return Arrays.stream(nums).max().getAsInt();
    }

    public int findMin(int[] nums){
        return Arrays.stream(nums).min().getAsInt();
    }
    public int calculateTotal(int[] nums,int mid){
        int total=0;
        for(int num:nums){
            total += (int) Math.ceil((double) num / mid);
        }
        return total;

    }
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int right=findMax(nums);
        int ans=Integer.MAX_VALUE;
        while(left<=right){
            int mid=(left+right)/2;
            int total=calculateTotal(nums,mid);
            if (total<=threshold){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    } 
}