class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)return false;
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(map.keySet());
        while(!pq.isEmpty()){
            int first=pq.peek();
            for(int i=0;i<groupSize;i++){
                int curr=first+i;
                if(!map.containsKey(curr)){
                    return false;
                }
                int freq=map.get(curr);
                if(freq==1){
                    map.remove(curr);
                }else{
                    map.put(curr,freq-1);
                }
            }
            while(!pq.isEmpty()&& !map.containsKey(pq.peek())){
                pq.poll();
            }
        }
        return true;
    }
}