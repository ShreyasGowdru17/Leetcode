class Solution:
    def minWindow(self, s: str, t: str) -> str:
        maxLen=10**9
        Hash=[0]*256

        for c in t:
            Hash[ord(c)]+=1
        
        n,m=len(s),len(t)
        sidx=n
        l=0
        r=0
        count=0
        while(r<n):
            if Hash[ord(s[r])]>0:
                count+=1
            Hash[ord(s[r])]-=1
            while(count==m):
                if r-l+1<maxLen:
                    maxLen=r-l+1
                    sidx=l
                Hash[ord(s[l])]+=1
                if(Hash[ord(s[l])])>0:
                    count-=1
                l+=1
            r+=1
        return s[sidx:sidx+maxLen] 
