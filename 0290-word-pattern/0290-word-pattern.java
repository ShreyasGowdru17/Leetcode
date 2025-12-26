class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> patternFreq=new HashMap<>();
        Map<String,Character> stringFreq=new HashMap<>();
        String[] array=s.split(" ");
        int patternLength=pattern.length();
        int stringLength=array.length;
        if(patternLength!=stringLength) return false;
        for(int i=0;i<patternLength;i++){
            char ch=pattern.charAt(i);
            String str=array[i];
            if(patternFreq.containsKey(ch)) {
                if(!patternFreq.get(ch).equals(str))
                return false;
            }
            else{
                if(stringFreq.containsKey(str)) return false;
                 patternFreq.put(ch,str);
                 stringFreq.put(str,ch);
            }
           
        }
        return true;
    }
}