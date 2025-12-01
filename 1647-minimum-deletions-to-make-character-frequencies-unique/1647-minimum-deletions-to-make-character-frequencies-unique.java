class Solution {
    public int minDeletions(String s) {
       int[] freq=new int[26];
       int n=s.length();
       for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
       } 
       Arrays.sort(freq);
       Set<Integer> used=new HashSet<>();
       int deletions=0;
       for(int i=0;i<26;i++){
          while(used.contains(freq[i]) && freq[i]>0){
             freq[i]--;
             deletions++;
          }
          used.add(freq[i]);
       }
       return deletions;
    }
}