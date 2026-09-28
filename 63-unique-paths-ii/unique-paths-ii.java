class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][]dp=new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(obstacleGrid,m-1,n-1,dp);
    }
    private int helper(int[][]obstacleGrid,int i,int j,int[][]dp){
        if(i==0&&j==0){
            if(obstacleGrid[0][0]==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(obstacleGrid[i][j]==1)return 0;
        int left=helper(obstacleGrid,i,j-1,dp);
        int right=helper(obstacleGrid,i-1,j,dp);
        return dp[i][j]=left+right;
    }
}