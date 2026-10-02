class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][]next=new int[2][k+1];
        int[][]curr=new int[2][k+1];
        for(int day=n-1;day>=0;day--){
            for(int buy=0;buy<=1;buy++){
                for(int count=k;count>0;count--){
                    if(buy==1){
                        int take=-prices[day]+next[0][count];
                        int nottake=next[1][count];
                        curr[buy][count]=Math.max(take,nottake);
                    }else{
                        int sell=prices[day]+next[1][count-1];
                        int hold=next[0][count];
                        curr[buy][count]=Math.max(sell,hold);
                    }
                }
            }
            for(int i=0;i<2;i++){
                for(int j=0;j<k+1;j++){
                    next[i][j]=curr[i][j];
                }
            }
        }
        return next[1][k];
    }
}