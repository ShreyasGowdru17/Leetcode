class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<KeyPair> maxHeap=new PriorityQueue<>((a,b)->Double.compare(b.sqrt,a.sqrt));
        for(int[] point:points){
            maxHeap.offer(new KeyPair(point,Math.sqrt(point[0]*point[0]+point[1]*point[1])));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] result=new int[maxHeap.size()][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            result[i]=maxHeap.poll().point;
            i++;
        }
        return result;
    }
}
class KeyPair{
    double sqrt;
    int[] point;
    KeyPair(int[] point,double sqrt){
        this.sqrt=sqrt;
        this.point=point;
    }
}