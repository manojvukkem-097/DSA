class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0)return 0;
        int[][]next=new int[2][3];
        int[][]curr=new int[2][3];
        for(int day=n-1;day>=0;day--){
            for(int buy=0;buy<=1;buy++){
                for(int count=2;count>0;count--){
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
                for(int j=0;j<3;j++){
                    next[i][j]=curr[i][j];
                }
            }
        }
        return next[1][2];
    }
}