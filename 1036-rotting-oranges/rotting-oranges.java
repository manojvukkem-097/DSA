class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        int[][]dummy=new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int[]item=q.poll();
            int i=item[0],j=item[1],time=item[2];
            ans=Math.max(time,ans);
            dummy[i][j]=2;
            if(i-1>=0&&dummy[i-1][j]!=2&&grid[i-1][j]==1){
                q.add(new int[]{i-1,j,time+1});
                dummy[i-1][j]=2;
            }
            if(j-1>=0&&dummy[i][j-1]!=2&&grid[i][j-1]==1){
                q.add(new int[]{i,j-1,time+1});
                dummy[i][j-1]=2;
            }
            if(i+1<m&&dummy[i+1][j]!=2&&grid[i+1][j]==1){
                q.add(new int[]{i+1,j,time+1});
                dummy[i+1][j]=2;
            }
            if(j+1<n&&dummy[i][j+1]!=2&&grid[i][j+1]==1){
                q.add(new int[]{i,j+1,time+1});
                dummy[i][j+1]=2;
            }
        }
        boolean isall=true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&dummy[i][j]!=2){
                    isall=false;
                    break;
                }
            }
        }
        return isall?ans:-1;
    }
}