class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]map=new int[26];
        for(char ch:tasks){
            map[ch-'A']++;
        }
        int maxfreq=0;
        for(int num:map){
            maxfreq=Math.max(maxfreq,num);
        }
        int maxcount=0;
        for(int num:map){
            if(num==maxfreq){
                maxcount++;
            }
        }
        int time=(maxfreq-1)*(n+1)+maxcount;
        return Math.max(time,tasks.length);
    }
}