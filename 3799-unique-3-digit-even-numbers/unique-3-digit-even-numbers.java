class Solution {
    public int totalNumbers(int[] digits) {
        int ans=0;
        int[]freq=new int[10];
        for(int digit:digits){
            freq[digit]++;
        }
        for(int i=100;i<1000;i+=2){
            int d1=i/100;
            int d2=(i/10)%10;
            int d3=i%10;
            freq[d1]--;
            freq[d2]--;
            freq[d3]--;
            if(freq[d1]>=0&&freq[d2]>=0&&freq[d3]>=0){
                ans++;
            }
            freq[d1]++;
            freq[d2]++;
            freq[d3]++;
        }
        return ans;
    }
}