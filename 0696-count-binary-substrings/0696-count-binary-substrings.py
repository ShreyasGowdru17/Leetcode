class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        cur=1
        prev=0
        count=0
        for i in range(1,len(s)):
            if s[i]==s[i-1]:
                cur+=1
            else:
                count+=min(prev,cur)
                prev=cur
                cur=1
        count+=min(prev,cur)
        return count

        