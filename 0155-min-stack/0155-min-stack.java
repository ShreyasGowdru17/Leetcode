class MinStack {

    private Stack<Long> stack;
    private long minimum;
    public MinStack() {
        stack=new Stack<>();
        minimum=Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long value=val;
        if(stack.isEmpty()){
            stack.push(value);
            minimum=value;
        }
        else{
            if(value<minimum){
                stack.push(2*value-minimum);
                minimum=value;
            }
            else{
                stack.push(value);
            } 
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        long value=stack.pop();
        if(value<minimum){
            minimum=2*minimum-value;
        }
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        long top=stack.peek();
        if(top<minimum){
            return (int)minimum;
        }
        return (int)top;
    }
    
    public int getMin() {
        return (int)minimum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */