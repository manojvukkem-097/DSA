class Solution {
    int MOD=1000000007;
    int m,n;
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int[][]dp=new int[m][n];
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1&&j==n-1)continue;
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
                        right=dp[nextr][nextc];
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
                        down=dp[nextr][nextc];
                    }
                }
                dp[i][j]=(int)((right+down)%MOD);
            }
        }
        return dp[0][0];
    }
}