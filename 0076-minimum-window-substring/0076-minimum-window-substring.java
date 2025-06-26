import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        int left=0;
        int right=0;
        int count=0;
        int minLen=Integer.MAX_VALUE;
        int m=t.length();
        int n=s.length();
        int startIndex=-1;
        Map<Character,Integer> map=t.chars()
                                    .mapToObj(c->(char)c)
                                    .collect(Collectors.groupingBy(
                                        Function.identity(),
                                        Collectors.summingInt(c->1)
                                    ));
        while(right<n){
            if (map.getOrDefault(s.charAt(right),0)>0){
                count++;
            }
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)-1);
            while(count==m){

                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startIndex=left;
                }
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)+1);
                if(map.getOrDefault(s.charAt(left),0)>0){
                    count--;
                }
                left++;
            }
            right++;
        }
        return (startIndex == -1) ? "" :s.substring(startIndex,startIndex+minLen);
    }
}