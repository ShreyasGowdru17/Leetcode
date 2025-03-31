class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def checkLive(a,b,m,n):
            count_1=0
            for i in range(a-1,a+2):
                if i<0 or i>=m:
                    continue
                for j in range(b-1,b+2):
                    if j<0 or j>=n or (i==a and j==b):
                        continue
                    if board[i][j]==1:
                        count_1+=1
            return count_1
        
        m=len(board)
        n=len(board[0])
        counter=[]
        for i in range(m):
            for j in range(n):
                count_1=checkLive(i,j,m,n)
                if board[i][j]==1 and (count_1<2 or count_1>3):
                    counter.append([i,j,0])
                elif board[i][j]==0 and (count_1==3):
                     counter.append([i,j,1])

        for i,j,val in counter:
            board[i][j]=val

        


            

