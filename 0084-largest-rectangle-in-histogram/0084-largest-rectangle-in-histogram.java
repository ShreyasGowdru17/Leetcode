class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=Integer.MIN_VALUE;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int nse=i;
                int element=stack.pop();
                int pse=stack.isEmpty()?-1:stack.peek();
                maxArea=Math.max(maxArea,heights[element]*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int nse=heights.length;
            int element=stack.pop();
            int pse=stack.isEmpty()?-1:stack.peek();
            maxArea=Math.max(maxArea,heights[element]*(nse-pse-1));
        }
        return maxArea;
    }
}