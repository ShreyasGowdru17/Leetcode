class Solution {
    public int largestRectangle(int[] nums){
        Stack<Integer> stack=new Stack<>();
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[i]<nums[stack.peek()]){
                int nse=i;
                int element=stack.pop();
                int pse=stack.isEmpty()?-1:stack.peek();
                maxArea=Math.max(maxArea,nums[element]*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int nse=nums.length;
            int element=stack.pop();
            int pse=stack.isEmpty()?-1:stack.peek();
            maxArea=Math.max(maxArea,nums[element]*(nse-pse-1));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int[][] newMatrix=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            int count=0;
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][i]=='1'){
                    count++;
                    newMatrix[j][i]=count;
                }else{
                    count=0;
                    newMatrix[j][i]=0;
                }
            }
        }
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            int area=largestRectangle(newMatrix[i]);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}