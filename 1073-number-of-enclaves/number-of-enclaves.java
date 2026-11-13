class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        int[][]dummy=new int[m][n];
        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                dummy[0][i]=1;
                q.add(new int[]{0,i});
            }
            if(grid[m-1][i]==1){
                dummy[m-1][i]=1;
                q.add(new int[]{m-1,i});
            }
        }
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                dummy[i][0]=1;
                q.add(new int[]{i,0});
            }
            if(grid[i][n-1]==1){
                dummy[i][n-1]=1;
                q.add(new int[]{i,n-1});
            }
        }
        while(!q.isEmpty()){
            int[]top=q.poll();
            if(top[0]-1>=0&&grid[top[0]-1][top[1]]==1&&dummy[top[0]-1][top[1]]==0){
                dummy[top[0]-1][top[1]]=1;
                q.add(new int[]{top[0]-1,top[1]});
            }if(top[0]+1<m &&grid[top[0]+1][top[1]]==1&&dummy[top[0]+1][top[1]]==0){
                dummy[top[0]+1][top[1]]=1;
                q.add(new int[]{top[0]+1,top[1]});
            }
            if(top[1]-1>=0&&grid[top[0]][top[1]-1]==1&&dummy[top[0]][top[1]-1]==0){
                dummy[top[0]][top[1]-1]=1;
                q.add(new int[]{top[0],top[1]-1});
            }
            if(top[1]+1<n&&grid[top[0]][top[1]+1]==1&&grid[top[0]][top[1]+1]==1){
                dummy[top[0]][top[1]+1]=1;
                q.add(new int[]{top[0],top[1]+1});
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=dummy[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}