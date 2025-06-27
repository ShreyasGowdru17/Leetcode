class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set =new HashSet<>();
        int left=0;
        int right=k;
        int n=s.length();
        while(right<=n){
            set.add(s.substring(left,right));
            left++;
            right++;
        }
        System.out.println(set);
        return set.size()==(1<<k);
    }
}