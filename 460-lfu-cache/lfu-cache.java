class LFUCache {
    class Node{
        int key,val,freq;
        Node prev,next;
        Node(int key,int value){
            this.key=key;
            this.val=value;
            this.freq=1;
        }
    }
    class doublelist{
        Node head,tail;
        int size;
        doublelist(){
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            head.next=tail;
            tail.prev=head;
            this.size=0;
        }
        void add(Node curr){
            curr.next=head.next;
            head.next.prev=curr;
            head.next=curr;
            curr.prev=head;
            size++;
        }
        void remove(Node curr){
            curr.next.prev=curr.prev;
            curr.prev.next=curr.next;
            size--;
        }
        Node removeLast(){
            if(size>0){
                Node r=tail.prev;
                remove(r);
                return r;
            }
            return null;
        }
    }
    private final int capacity;
    private int currsize;
    private int minfreq;
    private final Map<Integer,Node>cache;
    private final Map<Integer,doublelist>fm;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.currsize=0;
        this.minfreq=0;
        cache=new HashMap<>();
        fm=new HashMap<>();
    }
    
    public int get(int key) {
        Node curr=cache.get(key);
        if(curr==null)return -1;
        update(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0)return;
        if(cache.containsKey(key)){
            Node curr=cache.get(key);
            update(curr);
            curr.val=value;
        }else{
            if(currsize==capacity){
                doublelist removed=fm.get(minfreq);
                Node r=removed.removeLast();
                cache.remove(r.key);
                currsize--;
            }
            Node added=new Node(key,value);
            cache.put(key,added);
            minfreq=1;
            doublelist minlist=fm.getOrDefault(minfreq,new doublelist());
            minlist.add(added);
            fm.put(minfreq,minlist);
            currsize++;
        }
    }
    private void update(Node curr){
        int oldfreq=curr.freq;
        doublelist oldlist=fm.get(oldfreq);
        oldlist.remove(curr);
        if(oldfreq==minfreq && oldlist.size==0){
            minfreq++;
        }
        curr.freq++;
        doublelist newlist=fm.getOrDefault(curr.freq,new doublelist());
        newlist.add(curr);
        fm.put(curr.freq,newlist);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */