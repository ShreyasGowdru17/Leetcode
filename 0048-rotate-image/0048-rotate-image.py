class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m=len(matrix[0])
        n=len(matrix)

        for i in range(m):
            for j in range(i):
                matrix[i][j],matrix[j][i]=matrix[j][i],matrix[i][j]
            
        print(matrix)
        for i in range(m):
            matrix[i].reverse()
        