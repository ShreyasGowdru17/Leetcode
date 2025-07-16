class Solution {
    public int[] findPse(int[] nums){
        int[] result=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            result[i]= stack.isEmpty() ?-1:stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int[] findNse(int[] nums){
        int[] result=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&& nums[stack.peek()]>=nums[i]){
                    stack.pop();
            }
            result[i]=stack.isEmpty() ? nums.length:stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int[] findPgee(int[] nums){
        int[] result=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int[] findNge(int[] nums){
        int[] result=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&& nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?nums.length:stack.peek();
            stack.push(i);
        }
        return result;
    }
    public long sumSubarrayMin(int[] nums){
        int[] psee=findPse(nums);
        int[] nse=findNse(nums);
        long total=0;
        int mod=(int)1e9+7;
        for(int i=0;i<nums.length;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            long result=(nums[i]*1L*left*right);
            total=(total+result);
        }
        return total;
    }
    public long sumSubarrayMax(int[] nums){
        int[] pgee=findPgee(nums);
        int[] nge=findNge(nums);
        long total=0;
        int mod=(int)1e9+7;
        for(int i=0;i<nums.length;i++){
            int left=i-pgee[i];
            int right=nge[i]-i;
            long result=(nums[i]*1L*left*right);
            total=(total+result);
        }
        return total;
    }
    public long subArrayRanges(int[] nums) {
        int mod=(int)1e9+7;
        return (sumSubarrayMax(nums)-sumSubarrayMin(nums));
    }
}