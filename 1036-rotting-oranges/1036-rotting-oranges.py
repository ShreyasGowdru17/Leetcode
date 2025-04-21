from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        def isSafe(i,j,m,n):
            return 0<=i<m and 0<=j<n
        
        m=len(grid)
        n=len(grid[0])
        q=deque()
        directions=[(-1, 0), (1, 0), (0, -1), (0, 1)]
        time=-1

        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    q.append((i,j))

        while q:

            for _ in range(len(q)):
                i,j=q.popleft()
                for dire in directions:
                    x=i+dire[0]
                    y=j+dire[1]

                    if isSafe(x,y,m,n) and grid[x][y]==1:
                        grid[x][y]=2
                        q.append((x,y))
            time+=1
        
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    return -1
        return max(0,time)
                


        