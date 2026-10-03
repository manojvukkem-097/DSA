class Solution {
    public int maxProfit(int[] prices, int fee) {
        int nextbuy=0,nextsell=0,currbuy=0,currsell=0;
        for(int day=prices.length-1;day>=0;day--){
            for(int buy=1;buy>=0;buy--){
                if(buy==1){
                    int take=-prices[day]+nextsell;
                    int nottake=nextbuy;
                    currbuy=Math.max(take,nottake);
                }else{
                    int sell=prices[day]-fee+nextbuy;
                    int hold=nextsell;
                    currsell=Math.max(sell,hold);
                }
            }
            nextsell=currsell;
            nextbuy=currbuy;
        }
        return nextbuy;
    }
}