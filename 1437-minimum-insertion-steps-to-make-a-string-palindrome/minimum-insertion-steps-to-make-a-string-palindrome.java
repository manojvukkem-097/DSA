class Solution {
    public int minInsertions(String s) {
        String str=new StringBuilder(s).reverse().toString();
        return s.length()-lcs(s,str);
    }
    private int lcs(String src,String target){
        int[][]dp=new int[src.length()][src.length()];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(src,target,src.length()-1,target.length()-1,dp);
    }
    private int helper(String src,String target,int i,int j,int[][]dp){
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(src.charAt(i)==target.charAt(j)){
            return dp[i][j]=1+helper(src,target,i-1,j-1,dp);
        }
        return dp[i][j]=Math.max(helper(src,target,i,j-1,dp),helper(src,target,i-1,j,dp));
    }
}