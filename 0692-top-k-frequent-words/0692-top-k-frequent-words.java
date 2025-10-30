class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Long> map=Arrays.stream(words)
                                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        PriorityQueue<KeyPair> minHeap=new PriorityQueue<>((a,b)->{
            if(a.value==b.value) return b.key.compareTo(a.key);
            return Long.compare(a.value,b.value);
        });
        for(Map.Entry<String,Long> entry:map.entrySet()){
            minHeap.offer(new KeyPair(entry.getKey(),entry.getValue()));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        List<String> result=new ArrayList<>();

        while(!minHeap.isEmpty()){
            result.add(minHeap.poll().key);
        
        }
        Collections.reverse(result);
        return result;
    }
}
class KeyPair{
    String key;
    long value;
    KeyPair(String key,long value){
        this.key=key;
        this.value=value;
    }
}