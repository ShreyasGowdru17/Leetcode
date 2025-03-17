from typing import *

def superiorElements(a : List[int]) -> List[int]:
    # Write your code 
    maxElementArray=[a[-1]]
    for i in range(len(a)-2,-1,-1):
        if a[i]>a[i+1] and a[i]>maxElementArray[-1]:
            maxElementArray.append(a[i])
        
    return maxElementArray