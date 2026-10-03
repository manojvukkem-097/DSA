class Solution {
    public int maxProfit(int[] prices) {
        int[][]dp=new int[prices.length][2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(prices,0,1,dp);
    }
    private int helper(int[]prices,int day,int buy,int[][]dp){
        if(day>=prices.length){
            return 0;
        }
        if(dp[day][buy]!=-1)return dp[day][buy];
        if(buy==1){
            int take=-prices[day]+helper(prices,day+1,0,dp);
            int nottake=helper(prices,day+1,1,dp);
            return dp[day][buy]=Math.max(take,nottake);
        }else{
            int sell=prices[day]+helper(prices,day+2,1,dp);
            int hold=helper(prices,day+1,0,dp);
            return dp[day][buy]=Math.max(sell,hold);
        }
    }
}