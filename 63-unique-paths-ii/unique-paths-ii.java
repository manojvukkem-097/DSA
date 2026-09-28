class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][]dp=new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    if(obstacleGrid[0][0]==1){
                        dp[0][0]=0;
                    }else{
                        dp[0][0]=1;
                    }
                }else{
                    if(obstacleGrid[i][j]==1){
                        dp[i][j]=0;
                    }else{
                        int up=0,left=0;
                        if(i>0)up=dp[i-1][j];
                        if(j>0)left=dp[i][j-1];
                        dp[i][j]=up+left;
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}