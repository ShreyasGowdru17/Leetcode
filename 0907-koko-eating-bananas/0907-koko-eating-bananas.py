class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def calculate(piles,mid):
            requiredHours=0
            for pile in piles:
                requiredHours+=math.ceil(pile/mid)
            return requiredHours
        
        low=1
        high=max(piles)

        while(low<=high):
            mid=(low+high)//2
            requiredHours=calculate(piles,mid)
            if requiredHours<=h:
                high=mid-1
            else:
                low=mid+1
        return low
        