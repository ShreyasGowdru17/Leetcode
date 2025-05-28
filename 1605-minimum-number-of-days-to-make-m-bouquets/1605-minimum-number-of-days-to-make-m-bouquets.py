class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        def canMake(bloomDay,mid,k,m):
            bouquet=0
            adjacent=0
            for bloom in bloomDay:
                if bloom<=mid:
                    adjacent+=1
                    if adjacent==k:
                        bouquet+=1
                        adjacent=0
                        if bouquet>=m:
                            return True
                else:
                    adjacent=0
            return False
        low=min(bloomDay)
        high=max(bloomDay)
        ans=-1
        while(low<=high):
            mid=(low+high)//2
            if canMake(bloomDay,mid,k,m):
                high=mid-1
                ans=mid
            else:
                low=mid+1
        
        return ans

        