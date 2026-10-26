class Solution {
    int m,n;
    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    long sum=helper(grid,i,j);
                    if(sum%k==0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    private long helper(int[][]grid,int i,int j){
        if(i<0||j<0||i>=m||j>=n){
            return 0;
        }
        if(grid[i][j]==0)return 0;
        long temp=grid[i][j];
        grid[i][j]=0;
        return temp+helper(grid,i,j-1)+helper(grid,i,j+1)+helper(grid,i-1,j)+helper(grid,i+1,j);
    }
}