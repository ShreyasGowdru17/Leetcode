class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x:x[0])
        array=[intervals[0]]
        for i in range(len(intervals)):
            if array[-1][-1]>=intervals[i][0]:
                if array[-1][-1]<intervals[i][-1]:
                    array[-1][-1]=intervals[i][-1]
            else:
                array.append(intervals[i])
        return array
        # res=[intervals[0]]
        # j=0
        # for i in range(1,len(intervals)):
        #     if res[j][-1]>=intervals[i][0]:
        #         if res[j][-1]<intervals[i][-1]:
        #             res[j][-1]=intervals[i][-1]
        #         else:
        #             pass
        #     else:
        #         res.append(intervals[i])
        #         j+=1
        # return res

        
        