class Solution:
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        def findMax(mat,mid):
            n=len(mat)
            maxEle=float('-inf')
            maxIdx=-1
            for i in range(n):
                if mat[i][mid]>maxEle:
                    maxEle=mat[i][mid]
                    maxIdx=i
            return maxIdx

        low=0 
        high=len(mat[0])-1
        
        while(low<=high):
            mid=(low+high)//2
            row=findMax(mat,mid)
            m=len(mat[0])
            if mid-1>=0:
                left=mat[row][mid-1]
            else:
                left=-1
            if mid+1<m:
                right=mat[row][mid+1]
            else:
                right=-1

            if(mat[row][mid]>left and mat[row][mid]>right):
                return [row,mid]
            elif (mat[row][mid]<right):
                low=mid+1
            else:
                high=mid-1
            
        return [-1,-1]
        