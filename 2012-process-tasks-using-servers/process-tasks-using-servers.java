class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n=servers.length,m=tasks.length;
        int[]ans=new int[m];
        PriorityQueue<int[]>tservers=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        for(int i=0;i<n;i++){
            tservers.offer(new int[]{servers[i],i});
        }
        PriorityQueue<int[]>busy=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[2]-b[2];
        });
        int time=0;
        for(int i=0;i<m;i++){
            time=Math.max(time,i);
            while(!busy.isEmpty()&&busy.peek()[0]<=time){
                int[]free=busy.poll();
                tservers.offer(new int[]{free[1],free[2]});
            }
            if(tservers.isEmpty()){
                time=busy.peek()[0];
                while(!busy.isEmpty()&&busy.peek()[0]<=time){
                    int[]free=busy.poll();
                    tservers.offer(new int[]{free[1],free[2]});
                }
            }
            int[]nextserver=tservers.poll();
            int newtime=time+tasks[i];
            busy.offer(new int[]{newtime,nextserver[0],nextserver[1]});
            ans[i]=nextserver[1];
        }
        return ans;
    }
}