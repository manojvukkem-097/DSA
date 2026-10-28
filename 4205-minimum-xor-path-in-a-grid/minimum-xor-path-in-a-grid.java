class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][][]dp=new int[m][n][1024];
        for(int x=0;x<1024;x++){
            dp[m-1][n-1][x]=x;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1&&j==n-1)continue;
                for(int x=0;x<1024;x++){
                    int mini=Integer.MAX_VALUE;
                    if(j+1<n)mini=Math.min(mini,dp[i][j+1][x^grid[i][j+1]]);
                    if(i+1<m)mini=Math.min(mini,dp[i+1][j][x^grid[i+1][j]]);
                    dp[i][j][x]=mini;
                }
            }
        }
        return dp[0][0][grid[0][0]];
    }
}