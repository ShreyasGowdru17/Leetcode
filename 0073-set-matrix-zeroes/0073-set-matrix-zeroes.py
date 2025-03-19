class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        rowSet=set()
        columnSet=set()

        m=len(matrix)
        n=len(matrix[0])

        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    rowSet.add(i)
                    columnSet.add(j)

        
        rowSet=list(rowSet)
        columnSet=list(columnSet)

        for row in rowSet:
            for j in range(n):
                if matrix[row][j]!=0:
                    matrix[row][j]=0
        
        for column in columnSet:
            for i in range(m):
                if matrix[i][column]!=0:
                    matrix[i][column]=0

        