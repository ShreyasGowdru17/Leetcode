class StockSpanner {

    class pair{
        int price;
        int index;

        pair(int index,int price){
            this.index=index;
            this.price=price;
        }
    }

    Stack<pair> stack;
    int index;
   
    public StockSpanner() {
         index=-1;
         stack=new Stack<>();
    }
    
    public int next(int price) {
        index++;
        int result=0;
        while(!stack.isEmpty() && stack.peek().price<=price){
            stack.pop();
        }
        result=index-(stack.isEmpty()?-1:stack.peek().index);
        stack.push(new pair(index,price));
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */