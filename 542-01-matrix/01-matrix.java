class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int[][]dummy=new int[m][n];
        Queue<int[]>q=new LinkedList<>();
        int inf=m*n+1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    dummy[i][j]=0;
                    q.add(new int[]{i,j});
                }else{
                    dummy[i][j]=inf;
                }
            }
        }
        while(!q.isEmpty()){
            int[]item=q.poll();
            int i=item[0],j=item[1];
            if(i-1>=0&&mat[i-1][j]==1){
                if(dummy[i-1][j]>dummy[i][j]+1){
                    dummy[i-1][j]=dummy[i][j]+1;
                    q.offer(new int[]{i-1,j});
                }
            }
            if(j-1>=0&&mat[i][j-1]==1){
                if(dummy[i][j-1]>dummy[i][j]+1){
                    dummy[i][j-1]=dummy[i][j]+1;
                    q.offer(new int[]{i,j-1});
                }
            }
            if(i+1<m&&mat[i+1][j]==1){
                if(dummy[i+1][j]>dummy[i][j]+1){
                    dummy[i+1][j]=dummy[i][j]+1;
                    q.offer(new int[]{i+1,j});
                }
            }
            if(j+1<n&&mat[i][j+1]==1){
                if(dummy[i][j+1]>dummy[i][j]+1){
                    dummy[i][j+1]=dummy[i][j]+1;
                    q.offer(new int[]{i,j+1});
                }
            }
        }
        return dummy;
    }
}