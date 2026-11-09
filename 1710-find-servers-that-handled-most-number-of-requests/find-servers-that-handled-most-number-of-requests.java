class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n=arrival.length;
        TreeSet<Integer>avail=new TreeSet<>();
        int[]count=new int[k];
        int maxi=0;
        for(int i=0;i<k;i++){
            avail.add(i);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            while(!pq.isEmpty()&&pq.peek()[0]<=arrival[i]){
                int[]item=pq.poll();
                avail.add(item[1]);
            }
            if(avail.isEmpty())continue;
            Integer server=avail.ceiling(i%k);
            if(server==null){
                server=avail.first();
            }
            pq.offer(new int[]{arrival[i]+load[i],server});
            avail.remove(server);
            count[server]++;
            maxi=Math.max(maxi,count[server]);
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            if(count[i]==maxi){
                ans.add(i);
            }
        }
        return ans;
    }
}