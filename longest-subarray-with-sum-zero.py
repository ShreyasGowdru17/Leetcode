from typing import *

def getLongestZeroSumSubarrayLength(arr : List[int]) -> int:
    maxCount=0
    freqCount={}
    leftSum=0

    for index,value in enumerate(arr):
        leftSum+=value
        if leftSum==0:
            maxCount=max(maxCount,index+1)
        elif leftSum in freqCount:
            freqCount[leftSum][-1]=index
            maxCount=max(maxCount, index-freqCount[leftSum][0])
        else:
            freqCount[leftSum]=[index,index]

    return maxCount