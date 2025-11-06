class Solution {
    public int leastInterval(char[] tasks, int n) {
       Map<Character,Integer> map=new HashMap<>();
       for(char ch:tasks){
           map.put(ch,map.getOrDefault(ch,0)+1);
       }
       PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
       maxHeap.addAll(map.values());
       
       
      
       int time=0;
       while(!maxHeap.isEmpty()){
        int cycle=n+1;
        int i=0;
        List<Integer> temp=new ArrayList<>();
        while(i<cycle && !maxHeap.isEmpty()){
            int count=maxHeap.poll();
            time++;
            i++;
            count--;
            if(count>0) temp.add(count);
        }

        for(int ele:temp){
            maxHeap.offer(ele);
        }

        if(!maxHeap.isEmpty()){
            time+=(cycle-i);
        }
       }
      return time;
    }
}