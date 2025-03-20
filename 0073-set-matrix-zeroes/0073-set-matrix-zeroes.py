class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m=len(matrix)
        n=len(matrix[0])
        col0=1

        for i in range(m):
            for j in range(n):
                if j==0 and matrix[i][j]==0:
                    col0=0
                    matrix[i][0]=0
                elif matrix[i][j]==0:
                    matrix[0][j]=0
                    matrix[i][0]=0

        for i in range(1,m):
            for j in range(1,n):
                if matrix[i][j]!=0:
                    if matrix[0][j]==0 or matrix[i][0]==0:
                        matrix[i][j]=0

        
        if matrix[0][0]==0:
            for j in range(n):
                matrix[0][j]=0
        if col0==0:
            for i in range(m):
                matrix[i][0]=0
        
        # rowSet=set()
        # columnSet=set()

        # m=len(matrix)
        # n=len(matrix[0])

        # for i in range(m):
        #     for j in range(n):
        #         if matrix[i][j]==0:
        #             rowSet.add(i)
        #             columnSet.add(j)

        
        # rowSet=list(rowSet)
        # columnSet=list(columnSet)

        # for row in rowSet:
        #     for j in range(n):
        #         if matrix[row][j]!=0:
        #             matrix[row][j]=0
        
        # for column in columnSet:
        #     for i in range(m):
        #         if matrix[i][column]!=0:
        #             matrix[i][column]=0

        