class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        int n=isConnected.length;
        boolean[]visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,isConnected);
                ans++;
            }
        }
        return ans;
    }
    private void dfs(int i,boolean[]visited,int[][]isConnected){
        visited[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1&&!visited[j]){
                dfs(j,visited,isConnected);
            }
        }
    }
}