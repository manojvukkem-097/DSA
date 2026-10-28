class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][][]dp=new int[m][n][1024];
        for(int[][]row:dp){
            for(int[]col:row){
                Arrays.fill(col,-1);
            }
        }
        return helper(grid,0,0,grid[0][0],dp);
    }
    private int helper(int[][]grid,int i,int j,int x,int[][][]dp){
        if(i==grid.length-1 && j==grid[0].length-1){
            return x;
        }
        if(dp[i][j][x]!=-1)return dp[i][j][x];
        int mini=Integer.MAX_VALUE;
        if(j+1<grid[0].length)mini=Math.min(mini,helper(grid,i,j+1,x^grid[i][j+1],dp));
        if(i+1<grid.length)mini=Math.min(mini,helper(grid,i+1,j,x^grid[i+1][j],dp));
        return dp[i][j][x]=mini;
    }
}