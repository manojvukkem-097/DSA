class Solution {
    public int maxProfit(int[] prices) {
        int next2buy=0,next2sell=0,nextbuy=0,nextsell=0,currbuy=0,currsell=0;
        for(int day=prices.length-1;day>=0;day--){
            currbuy=Math.max(-prices[day]+nextsell,nextbuy);
            currsell=Math.max(prices[day]+next2buy,nextsell);
            next2buy=nextbuy;
            next2sell=nextsell;
            nextbuy=currbuy;
            nextsell=currsell;
        }
        return currbuy;
    }
}