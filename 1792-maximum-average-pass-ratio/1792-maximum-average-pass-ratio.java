class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));

        for(int i=0;i<classes.length;i++){
            double cur=(double) classes[i][0]/classes[i][1];
            double prev=(double)(classes[i][0]+1)/(classes[i][1]+1);
            maxHeap.offer(new double[]{prev-cur,i});
        }
        
        while(extraStudents-->0){
            double[] top=maxHeap.poll();
            int i=(int) top[1];
            classes[i][0]+=1;
            classes[i][1]+=1;
            double cur=(double) classes[i][0]/classes[i][1];
            double prev=(double)(classes[i][0]+1)/(classes[i][1]+1);
            maxHeap.offer(new double[]{prev-cur,i});
        }
        
        double ans=0.0;
        for(int[] c:classes){
            ans+=(double) c[0]/c[1];
        }
        return ans/classes.length;
    }
}
