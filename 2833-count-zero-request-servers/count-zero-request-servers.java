class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m=queries.length;
        int[]map=new int[n+1];
        Arrays.sort(logs,(a,b)->a[1]-b[1]);
        int[][]qsorted=new int[m][2];
        for(int i=0;i<m;i++){
            qsorted[i][0]=queries[i];
            qsorted[i][1]=i;
        }
        Arrays.sort(qsorted,(a,b)->a[0]-b[0]);
        int l=0,r=0;
        int count=0;
        int[]ans=new int[m];
        for(int i=0;i<m;i++){
            int start=qsorted[i][0]-x;
            int end=qsorted[i][0];
            while(r<logs.length&&logs[r][1]<=end){
                int serverid=logs[r][0];
                if(map[serverid]==0){
                    count++;
                }
                map[serverid]++;
                r++;
            }
            while(l<logs.length&&logs[l][1]<start){
                int serverid=logs[l][0];
                map[serverid]--;
                if(map[serverid]==0){
                    count--;
                }
                l++;
            }
            ans[qsorted[i][1]]=n-count;
        }
        return ans;
    }
}