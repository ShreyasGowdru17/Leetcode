class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<KeyPair> maxHeap=new PriorityQueue<>((a,b)->      {
            if(a.abs==b.abs) return b.key-a.key;
            return b.abs-a.abs;
    });
        for(int num:arr){
            maxHeap.offer(new KeyPair(num,Math.abs(num-x)));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        List<Integer> result=new ArrayList<>();
        while(!maxHeap.isEmpty()){
            result.add(maxHeap.poll().key);
        }
        Collections.sort(result);
        return result;
    }
}
class KeyPair{
    int key;
    int abs;
    public KeyPair(int key,int abs){
        this.key=key;
        this.abs=abs;
    }
}