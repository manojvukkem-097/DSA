class Solution {
    public int totalNumbers(int[] digits) {
        int ans=0;
        int[]freq=new int[10];
        for(int digit:digits){
            freq[digit]++;
        }
        for(int d1=1;d1<10;d1++){
            if(freq[d1]==0)continue;
            freq[d1]--;
            for(int d2=0;d2<10;d2++){
                if(freq[d2]==0)continue;
                freq[d2]--;
                for(int d3=0;d3<10;d3+=2){
                    if(freq[d3]>0)ans++;
                }
                freq[d2]++;
            }
            freq[d1]++;
        }
        return ans;
    }
}