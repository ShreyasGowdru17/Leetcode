class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        prefixSum=0
        count=0
        freqCount=defaultdict(int)
        freqCount[0]=1

        for num in nums:
            prefixSum+=num
            count+=freqCount[prefixSum-k]
            freqCount[prefixSum]+=1

        print(freqCount)
        return count
            
    



        