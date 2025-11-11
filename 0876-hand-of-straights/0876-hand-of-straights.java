class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int ele:hand){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        while(!map.isEmpty()){
                int cur=map.firstKey();
                for(int i=0;i<groupSize;i++){
                    if(!map.containsKey(cur+i)) return false;
                    int val=map.get(cur+i);
                    val--;
                    if(val>=1) map.put(cur+i,val);
                    if(val==0) map.remove(cur+i);
                }
        }
        return true;
    }
}