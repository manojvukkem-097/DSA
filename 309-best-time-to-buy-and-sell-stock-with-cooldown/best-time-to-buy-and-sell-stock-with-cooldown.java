class Solution {
    public int maxProfit(int[] prices) {
        int[]next2=new int[2];
        int[]next1=new int[2];
        int[]curr=new int[2];
        for(int day=prices.length-1;day>=0;day--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    int take=-prices[day]+next1[0];
                    int nottake=next1[1];
                    curr[buy]=Math.max(take,nottake);
                }else{
                    int sell=prices[day]+next2[1];
                    int hold=next1[0];
                    curr[buy]=Math.max(sell,hold);
                }
            }
            next2=next1.clone();
            next1=curr.clone();
        }
        return curr[1];
    }
}