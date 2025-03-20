class Solution:
    def generate(self, numRows: int) -> List[List[int]]:

        finalArray=[]

        for i in range(numRows):
            rowArray=[]
            maxLength=i
            
            for j in range(maxLength+1):

                if j==0 or j==maxLength or i==0:
                    rowArray.append(1)
                else:
                    rowArray.append(finalArray[i-1][j]+finalArray[i-1][j-1])
                
            finalArray.append(rowArray)
            print(finalArray)

        return finalArray

        