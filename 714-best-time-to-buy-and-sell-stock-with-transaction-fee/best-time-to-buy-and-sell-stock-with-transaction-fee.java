class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[]next=new int[2];
        int[]curr=new int[2];
        for(int day=prices.length-1;day>=0;day--){
            for(int buy=1;buy>=0;buy--){
                if(buy==1){
                    int take=-prices[day]+next[0];
                    int nottake=next[1];
                    curr[buy]=Math.max(take,nottake);
                }else{
                    int sell=prices[day]-fee+next[1];
                    int hold=next[0];
                    curr[buy]=Math.max(sell,hold);
                }
            }
            next[0]=curr[0];
            next[1]=curr[1];
        }
        return next[1];
    }
}