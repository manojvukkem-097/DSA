class StockSpanner {
    private int[]pr;
    private int[]span;
    private int top;
    public StockSpanner() {
        pr=new int[10005];
        span=new int[10005];
        top=-1;
    }
    
    public int next(int price) {
        int sp=1;
        while(top!=-1 &&pr[top]<=price){
            sp+=span[top--];
        }
        top++;
        pr[top]=price;
        span[top]=sp;
        return sp;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */