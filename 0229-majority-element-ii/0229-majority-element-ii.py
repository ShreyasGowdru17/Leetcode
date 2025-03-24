class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        
        cnt1=0
        cnt2=0
        ele1=None
        ele2=None

        for i in range(len(nums)):
            if cnt1==0 and ele2!=nums[i]:
                ele1=nums[i]
                cnt1=1
            elif cnt2==0 and ele1!=nums[i]:
                ele2=nums[i]
                cnt2=1
            elif ele1==nums[i]:
                cnt1+=1
            elif ele2==nums[i]:
                cnt2+=1
            else:
                cnt1-=1
                cnt2-=1
            
        array=[]
        cnt1=0
        cnt2=0
        for i in range(len(nums)):
            if ele1==nums[i]:
                cnt1+=1
            if ele2==nums[i]:
                cnt2+=1

        if cnt1>(len(nums)//3):
            array.append(ele1)
        if cnt2>(len(nums)//3):
            array.append(ele2)

        return array


        