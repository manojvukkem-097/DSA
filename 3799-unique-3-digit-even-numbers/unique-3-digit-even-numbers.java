class Solution {
    public int totalNumbers(int[] digits) {
        int ans=0;
        int[]freq=new int[10];
        for(int digit:digits){
            freq[digit]++;
        }
        for(int i=100;i<1000;i+=2){
            int[]digit=new int[10];
            digit[i%10]++;
            digit[(i/10)%10]++;
            digit[(i/100)%10]++;
            boolean yes=true;
            for(int j=0;j<10;j++){
                if(digit[j]>freq[j]){
                    yes=false;
                    break;
                }
            }
            if(yes){
                ans++;
            }
        }
        return ans;
    }
}