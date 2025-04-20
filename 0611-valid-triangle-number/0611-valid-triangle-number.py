class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums=sorted(nums)
        count=0
        for c in range(len(nums)-1,1,-1):
            a=0
            b=c-1
            while a<b:
                if nums[a]+nums[b]>nums[c]:
                    count+=b-a
                    b-=1
                else:
                    a+=1
        return count

        