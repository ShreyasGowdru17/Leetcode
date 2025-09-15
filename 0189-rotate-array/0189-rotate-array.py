class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        k=k%n
        j=n-1
        i=n-k
        #reverse last k elements
        while(i<=j):
            nums[i],nums[j]=nums[j],nums[i]
            i+=1
            j-=1
        
        i=0
        j=n-k-1
        #reverse first n-k elements
        while(i<=j):
            nums[i],nums[j]=nums[j],nums[i]
            i+=1
            j-=1

        i=0
        j=n-1
        #reverse whole array
        while(i<=j):
            nums[i],nums[j]=nums[j],nums[i]
            i+=1
            j-=1

        return nums
        
