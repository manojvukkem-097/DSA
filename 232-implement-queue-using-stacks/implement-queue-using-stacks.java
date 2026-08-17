class MyQueue {
    private Stack<Integer>s;
    private Stack<Integer>b;
    public MyQueue() {
        s=new Stack<>();
        b=new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
    }
    
    public int pop() {
        peek();
        return b.pop();
    }
    
    public int peek() {
        if(b.isEmpty()){
            while(!s.isEmpty()){
                b.push(s.pop());
            }
        }
        return b.peek();
    }
    
    public boolean empty() {
        return s.isEmpty()&b.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */