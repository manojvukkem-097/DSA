class Solution {
    int MOD=1000000007;
    int m,n;
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int[][]dp=new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return (int)helper(grid,0,0,dp);
    }
    private int helper(int[][]grid,int i,int j,int[][]dp){
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(i<0||i>=m||j>=n||j<0){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        long right=0,down=0;
        if(j+1<n){
            int nextr=i,nextc=j+1;
            int dir=0;
            while(nextr<m&&nextc<n&&grid[nextr][nextc]==1){
                if(dir==0){
                    nextr++;
                    dir=1;
                }else{
                    nextc++;
                    dir=0;
                }
            }
            if(nextr<m&&nextc<n){
                right=helper(grid,nextr,nextc,dp);
            }
        }
        if(i+1<m){
            int nextr=i+1,nextc=j;
            int dir=0;
            while(nextr<m&&nextc<n&&grid[nextr][nextc]==1){
                if(dir==0){
                    nextc++;
                    dir=1;
                }else{
                    nextr++;
                    dir=0;
                }
            }
            if(nextr<m&&nextc<n){
                down=helper(grid,nextr,nextc,dp);
            }
        }
        return dp[i][j]=(int)((right+down)%MOD);
    }
}