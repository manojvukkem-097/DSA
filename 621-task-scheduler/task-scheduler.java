class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time=0;
        int[]map=new int[26];
        for(char ch:tasks){
            map[ch-'A']++;
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(map[i]>0){
                pq.add(map[i]);
            }
        }
        while(!pq.isEmpty()){
            List<Integer>temp=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    int freq=pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for(int i=0;i<temp.size();i++){
                if(temp.get(i)>0){
                    pq.add(temp.get(i));
                }
            }
            if(!pq.isEmpty()){
                time+=n+1;
            }else{
                time+=temp.size();
            }
        }
        return time;
    }
}