class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int right=0;
        int maxLen=0;
        int n=fruits.length;
        Map<Integer,Integer> basket=new HashMap<>();
        while(right<n){
            basket.put(fruits[right],basket.getOrDefault(fruits[right],0)+1);
           /* while(basket.size()>2){
                basket.put(fruits[left],basket.get(fruits[left])-1);
                if(basket.get(fruits[left])==0){
                    basket.remove(fruits[left]);
                }
                left++;
            }*/
            if(basket.size()>2){
                basket.put(fruits[left],basket.get(fruits[left])-1);
                if(basket.get(fruits[left])==0){
                    basket.remove(fruits[left]);
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}