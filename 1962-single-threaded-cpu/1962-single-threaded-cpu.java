class Solution {
    public int[] getOrder(int[][] tasks) {
       int n=tasks.length;
       int[][] array=new int[n][3];
       PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return a[2]-b[2];
            return a[1]-b[1];
       });
       for(int i=0;i<n;i++){
            array[i][0]=tasks[i][0];
            array[i][1]=tasks[i][1];
            array[i][2]=i;
       }
       Arrays.sort(array,(a,b)->Integer.compare(a[0],b[0]));
       int[] result=new int[n];
       int time=0;
       int i=0;
       int j=0;
       while(i<n || !minHeap.isEmpty()){
            if(minHeap.isEmpty() && time<array[i][0]){
                time=array[i][0];
            }

            while(i<n && array[i][0]<=time){
                minHeap.offer(array[i]);
                i++;
            }

            int[] task=minHeap.poll();
            result[j++]=task[2];
            time+=task[1];
       }
       return result;
    }
}
