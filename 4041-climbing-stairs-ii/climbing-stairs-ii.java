class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp0=0,dp1=0,dp2=0,current=0;
        for(int i=1;i<=n;i++){
            int ans=Integer.MAX_VALUE;
            for(int j=1;j<=3;j++){
                int cost=costs[i-1]+j*j;
                int nextcost=0;
                if(j==1&&i-1>=0)nextcost=dp2;
                else if(j==2&&i-2>=0)nextcost=dp1;
                else if(j==3&&i-3>=0)nextcost=dp0;
                ans=Math.min(ans,cost+nextcost);
            }
            dp0=dp1;
            dp1=dp2;
            dp2=ans;
        }
        return dp2;
    }
}