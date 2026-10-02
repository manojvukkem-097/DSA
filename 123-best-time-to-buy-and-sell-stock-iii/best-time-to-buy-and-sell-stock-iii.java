class Solution {
    public int maxProfit(int[] prices) {
        int[][][]dp=new int[prices.length][2][3];
        for(int[][]row:dp){
            for(int[]col:row){
                Arrays.fill(col,-1);
            }
        }
        return helper(prices,0,1,2,dp);
    }
    private int helper(int[]prices,int day,int buy,int count,int[][][]dp){
        if(day==prices.length||count==0){
            return 0;
        }
        if(dp[day][buy][count]!=-1)return dp[day][buy][count];
        if(buy==1){
            int take=-prices[day]+helper(prices,day+1,0,count,dp);
            int nottake=helper(prices,day+1,1,count,dp);
            return dp[day][buy][count]=Math.max(take,nottake);
        }else{
            int sell=prices[day]+helper(prices,day+1,1,count-1,dp);
            int hold=helper(prices,day+1,0,count,dp);
            return dp[day][buy][count]=Math.max(sell,hold);
        }
    }
}