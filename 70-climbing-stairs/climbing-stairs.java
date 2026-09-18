class Solution {
    public int climbStairs(int n) {
        if(n<=1)return 1;
        int[][]t={{1,1},{1,0}};
        power(t,n-1);
        return t[0][0]+t[0][1];
    }
    private void power(int[][]t,int p){
        if(p<=1)return;
        int[][]m={{1,1},{1,0}};
        power(t,p/2);
        multiply(t,t);
        if(p%2!=0){
            multiply(t,m);
        }
    }
    private void multiply(int[][]a,int[][]b){
        int w=a[0][0]*b[0][0]+a[0][1]*b[1][0];
        int x=a[0][0]*b[0][1]+a[0][1]*b[1][1];
        int y=a[1][0]*b[0][0]+a[1][1]*b[1][0];
        int z=a[1][0]*b[0][1]+a[1][1]*b[1][1];
        a[0][0]=w;
        a[0][1]=x;
        a[1][0]=y;
        a[1][1]=z;
    }
}