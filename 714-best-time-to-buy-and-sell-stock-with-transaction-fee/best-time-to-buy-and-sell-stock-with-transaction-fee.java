class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][]dp=new int[prices.length+1][2];
        for(int day=prices.length-1;day>=0;day--){
            for(int buy=1;buy>=0;buy--){
                if(buy==1){
                    int take=-prices[day]+dp[day+1][0];
                    int nottake=dp[day+1][1];
                    dp[day][buy]=Math.max(take,nottake);
                }else{
                    int sell=prices[day]-fee+dp[day+1][1];
                    int hold=dp[day+1][0];
                    dp[day][buy]=Math.max(sell,hold);
                }
            }
        }
        return dp[0][1];
    }
}