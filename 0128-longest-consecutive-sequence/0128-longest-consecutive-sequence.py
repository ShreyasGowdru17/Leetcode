class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        result=set()

        for i in range(len(nums)):
            result.add(nums[i])

        total=0
        m=len(result)

        for i in range(len(nums)):
            count=1

            if nums[i]+1 in result and nums[i]-1 not in result:
                result.remove(nums[i])
                cur=nums[i]+1

                while cur in result:
                    result.remove(cur)
                    cur=cur+1
                    count+=1

            total=max(total,count)

        return total if m>1 else m

                    




        