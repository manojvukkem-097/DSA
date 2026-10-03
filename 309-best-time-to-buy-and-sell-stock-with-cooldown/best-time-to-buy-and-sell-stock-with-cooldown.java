class Solution {
    public int maxProfit(int[] prices) {
        int next2buy=0,nextbuy=0,nextsell=0;
        for(int day=prices.length-1;day>=0;day--){
            int currbuy=Math.max(-prices[day]+nextsell,nextbuy);
            int currsell=Math.max(prices[day]+next2buy,nextsell);
            next2buy=nextbuy;
            nextbuy=currbuy;
            nextsell=currsell;
        }
        return nextbuy;
    }
}