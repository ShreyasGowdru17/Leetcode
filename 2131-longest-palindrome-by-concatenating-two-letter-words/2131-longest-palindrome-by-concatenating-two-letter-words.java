class Solution {
    private String reverseString(String reverse){
        return new StringBuilder(reverse).reverse().toString();
    }
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> freq=new HashMap<>();
        for(String word:words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        int length=0;
        boolean onceVisited=false;
        for(String word:words){
            String reversed=reverseString(word);
            if(freq.containsKey(word) && freq.containsKey(reversed))  {
                if(word.equals(reversed)){
                    if(freq.get(word)>=2){
                        freq.put(word,freq.get(word)-2);
                        length+=4;
                    }else if(freq.get(word)>0 && !onceVisited){
                        freq.put(word,freq.get(word)-1);
                        length+=2;
                        onceVisited=true;
                    }
                }else if(freq.get(word)>0 && freq.get(reversed)>0)              {
                    freq.put(word,freq.get(word)-1);
                    freq.put(reversed,freq.get(reversed)-1);
                    length+=4;
                }
            }
        }
        return length;
    }
}