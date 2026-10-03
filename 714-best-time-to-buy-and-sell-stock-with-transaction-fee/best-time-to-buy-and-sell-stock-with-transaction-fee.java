class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][]dp=new int[prices.length][2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(prices,0,1,fee,dp);
    }
    private int helper(int[]prices,int day,int buy,int fee,int[][]dp){
        if(day==prices.length){
            return 0;
        }
        if(dp[day][buy]!=-1)return dp[day][buy];
        if(buy==1){
            int take=-prices[day]+helper(prices,day+1,0,fee,dp);
            int nottake=helper(prices,day+1,1,fee,dp);
            return dp[day][buy]=Math.max(take,nottake);
        }else{
            int sell=prices[day]-fee+helper(prices,day+1,1,fee,dp);
            int hold=helper(prices,day+1,0,fee,dp);
            return dp[day][buy]=Math.max(sell,hold);
        }
    }
}