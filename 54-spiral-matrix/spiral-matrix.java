class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int anss=m*n;
        List<Integer>ans=new ArrayList<>();
        return helper(0,n-1,m,n,ans,matrix,anss);
    }
    private List<Integer> helper(int i,int j,int m,int n,List<Integer>ans,int[][]matrix,int anss){
        for(int k=i;k<n;k++){
            if(ans.size()==anss){
                return ans;
            }
            ans.add(matrix[i][k]);
        }
        for(int k=i+1;k<m;k++){
            if(ans.size()==anss){
                return ans;
            }
            ans.add(matrix[k][j]);
        }
        for(int k=j-1;k>=i;k--){
            if(ans.size()==anss){
                return ans;
            }
            ans.add(matrix[m-1][k]);
        }
        for(int k=m-2;k>=i+1;k--){
            if(ans.size()==anss){
                return ans;
            }
            ans.add(matrix[k][i]);
        }
        return ans.size()==anss?ans:helper(i+1,j-1,m-1,n-1,ans,matrix,anss);
    }
}