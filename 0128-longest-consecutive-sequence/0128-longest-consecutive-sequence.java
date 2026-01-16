class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }


        int total=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count=1;
            if(set.contains(nums[i]+1) && !set.contains(nums[i]-1)){
                set.remove(nums[i]);
                int cur=nums[i]+1;
                while(set.contains(cur)){
                    set.remove(cur);
                    cur++;
                    count++;
                }

            }
            total=Math.max(total,count);
        }
        return total;

    }
}