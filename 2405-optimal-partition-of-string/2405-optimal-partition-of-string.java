class Solution {
    public int partitionString(String s) {
       Map<Character,Integer> map=new HashMap<>();
       int left=0;
       int count=1;
       for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>=left){
                left=i;
                count++;
            }
            map.put(ch,i);
       }
       return count; 
    }
}