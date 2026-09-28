class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int ans=Integer.MAX_VALUE;
        int[]prev=new int[n];
        for(int i=0;i<n;i++)prev[i]=matrix[0][i];
        for(int i=1;i<n;i++){
            int[]curr=new int[n];
            for(int j=0;j<n;j++){
                int ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                int s=prev[j];
                if(j>0)ld=prev[j-1];
                if(j<n-1)rd=prev[j+1];
                curr[j]=matrix[i][j]+Math.min(s,Math.min(ld,rd));
            }
            prev=curr;
        }
        for(int i=0;i<n;i++){
            ans=Math.min(ans,prev[i]);
        }
        return ans;
    }
}