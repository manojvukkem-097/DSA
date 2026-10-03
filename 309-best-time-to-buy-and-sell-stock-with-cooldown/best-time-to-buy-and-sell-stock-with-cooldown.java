class Solution {
    public int maxProfit(int[] prices) {
        int next2buy=0,next2sell=0,nextbuy=0,nextsell=0,currbuy=0,currsell=0;
        for(int day=prices.length-1;day>=0;day--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    int take=-prices[day]+nextsell;
                    int nottake=nextbuy;
                    currbuy=Math.max(take,nottake);
                }else{
                    int sell=prices[day]+next2buy;
                    int hold=nextsell;
                    currsell=Math.max(sell,hold);
                }
            }
            next2buy=nextbuy;
            next2sell=nextsell;
            nextbuy=currbuy;
            nextsell=currsell;
        }
        return currbuy;
    }
}