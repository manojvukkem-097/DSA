class MinStack {
    private List<Integer>a;
    private List<Integer>b;
    public MinStack() {
        a=new ArrayList<>();
        b=new ArrayList<>();
    }
    
    public void push(int value) {
        if(b.isEmpty()|| value<=b.get(b.size()-1)){
            b.add(value);
        }
        a.add(value);
    }
    
    public void pop() {
        if(a.isEmpty())return;
        int removed=a.remove(a.size()-1);
        if(!b.isEmpty() && b.get(b.size()-1).equals(removed)){
            b.remove(b.size()-1);
        }
    }
    
    public int top() {
        if(a.isEmpty())return -1;
        return a.get(a.size()-1);
    }
    
    public int getMin() {
        if(b.isEmpty())return -1;
        return b.get(b.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */