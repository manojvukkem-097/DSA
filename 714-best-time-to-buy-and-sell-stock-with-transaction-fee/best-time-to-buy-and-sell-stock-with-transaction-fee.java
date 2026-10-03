class Solution {
    public int maxProfit(int[] prices, int fee) {
        int nextbuy=0,nextsell=0;
        for(int day=prices.length-1;day>=0;day--){
            int currbuy=Math.max(-prices[day]+nextsell,nextbuy);
            int currsell=Math.max(prices[day]-fee+nextbuy,nextsell);
            nextsell=currsell;
            nextbuy=currbuy;
        }
        return nextbuy;
    }
}