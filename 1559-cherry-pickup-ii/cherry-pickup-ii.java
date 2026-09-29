class Solution {
    public int cherryPickup(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][]prev=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)prev[i][j]=grid[m-1][j];
                else{
                    prev[i][j]=grid[m-1][j]+grid[m-1][i];
                }
            }
        }
        for(int r=m-2;r>=0;r--){
            int[][]curr=new int[n][n];
            for(int j1=0;j1<n;j1++){
                for(int j2=0;j2<n;j2++){
                    int maxi=0;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int nj1=j1+dj1;
                            int nj2=j2+dj2;
                            if(nj1>=0&&nj1<n&&nj2>=0&&nj2<n){
                                maxi=Math.max(maxi,prev[nj1][nj2]);
                            }
                        }
                    }
                    int current=(j1==j2)?grid[r][j1]:grid[r][j1]+grid[r][j2];
                    curr[j1][j2]=current+maxi;
                }
            }
            prev=curr;
        }
        return prev[0][n-1];
    }
}