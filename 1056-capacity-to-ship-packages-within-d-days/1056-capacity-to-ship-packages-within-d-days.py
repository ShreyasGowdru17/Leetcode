class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def calculateDays(capacity,weights):
            load=0
            days=0
            for i in range(len(weights)):
                if load+weights[i]>capacity:
                    days+=1
                    load=weights[i]
                else:
                    load+=weights[i]
            days+=1
            return days
        left=max(weights)
        right=sum(weights)
        while(left<=right):
            mid=(left+right)//2
            requiredDays=calculateDays(mid,weights)
            if requiredDays<=days:
                right=mid-1
            else:
                left=mid+1
        
        return left
        