class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq=new int[26];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int result=word.length();
        int cumulative_deleted=0;
        for(int i=0;i<26;i++){
            int deleted=cumulative_deleted;
            for(int j=25;j>i;j--){
                if(freq[j]-freq[i]<=k){
                    break;
                }
                deleted+=freq[j]-freq[i]-k;
            }
            result=Math.min(result,deleted);
            cumulative_deleted+=freq[i];
        }
        return result;
    }
}