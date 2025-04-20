class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        ans=[nums[0]]
        for i in range(1,len(nums)):
            if nums[i]>ans[-1]:
                ans.append(nums[i])
            else:
                low=0
                high=len(ans)-1
                while(low<high):
                    mid=(low+high)//2
                    if ans[mid]<nums[i]:
                        low=mid+1
                    else:
                        high=mid
                ans[low]=nums[i]
        return len(ans)