class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxHeap.offer(matrix[i][j]);
                if(maxHeap.size()>k){
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.poll();
    }
}