class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<KeyPair> minHeap=new PriorityQueue<>((a,b)->Long.compare(a.value,b.value));
        Map<Integer,Long> map=Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for(Map.Entry<Integer,Long> entry:map.entrySet()){
            minHeap.offer(new KeyPair(entry.getKey(),entry.getValue()));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        List<Integer> result=new ArrayList<>();
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll().key);
        }
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
class KeyPair{
    int key;
    long value;
    public KeyPair(int key,long value){
        this.key=key;
        this.value=value;
    }
}