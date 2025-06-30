class Solution {
    public int minimumCardPickup(int[] cards) {
        int left=0;
        int right=0;
        int n=cards.length;
        int minLen=Integer.MAX_VALUE;
        int flag=-1;
        Map<Integer,Integer> map=new HashMap<>();
        while(right<n){
            if(map.containsKey(cards[right]) && map.get(cards[right])>=left){
                flag=0;
                minLen=Math.min(minLen,(right-map.get(cards[right])+1));
                left++;
            }
            map.put(cards[right],right);
            right++;
        }
        
        if(flag==-1){
            return -1;
        }
        return minLen;
    }
}