import java.util.HashMap;
import java.util.Map;
import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()) return false;
        int k=s1.length();
        int left=0;
        int right=0;
        int count=0;
        Map<Character,Integer> map=s1.chars()
                                    .mapToObj(c->(char)c)
                                    .collect(Collectors.groupingBy(
                                        Function.identity(),
                                        Collectors.summingInt(c->1)
                                    ));
                
        int n=s2.length();
        while(right<n){
            if(map.getOrDefault(s2.charAt(right),0)>0){
                count++;
            }
            map.put(s2.charAt(right),map.getOrDefault(s2.charAt(right),0)-1);
            if(right-left+1>k){
                map.put(s2.charAt(left),map.getOrDefault(s2.charAt(left),0)+1);
                if(map.getOrDefault(s2.charAt(left),0)>0){
                    count--;
                }
                left++;
            }
            if(count==k){
                return true;
            }
            right++;
        }
        
        return false;
    }
}