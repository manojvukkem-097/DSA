class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0)return 0;
        int[][][]dp=new int[n+1][2][3];
        for(int day=n-1;day>=0;day--){
            for(int buy=0;buy<=1;buy++){
                for(int count=2;count>0;count--){
                    if(buy==1){
                        int take=-prices[day]+dp[day+1][0][count];
                        int nottake=dp[day+1][1][count];
                        dp[day][buy][count]=Math.max(take,nottake);
                    }else{
                        int sell=prices[day]+dp[day+1][1][count-1];
                        int hold=dp[day+1][0][count];
                        dp[day][buy][count]=Math.max(sell,hold);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}