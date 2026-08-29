class MedianFinder {
    private PriorityQueue<Integer>small;
    private PriorityQueue<Integer>large;
    public MedianFinder() {
        small=new PriorityQueue<>(Collections.reverseOrder());
        large=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);
        if(!small.isEmpty()&&!large.isEmpty()&&small.peek()>large.peek()){
            large.add(small.poll());
        }
        if(small.size()>large.size()+1){
            large.add(small.poll());
        }else if(large.size()>small.size()){
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size()>large.size()){
            return (double)small.peek();
        }
        return (small.peek()+large.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */