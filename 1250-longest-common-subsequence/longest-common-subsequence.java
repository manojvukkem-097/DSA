class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp=new int[text1.length()+1][text2.length()+1];
        for(int index1=1;index1<=text1.length();index1++){
            for(int index2=1;index2<=text2.length();index2++){
                if(text1.charAt(index1-1)==text2.charAt(index2-1)){
                    dp[index1][index2]=1+dp[index1-1][index2-1];
                }
                else{
                    dp[index1][index2]=Math.max(dp[index1-1][index2],dp[index1][index2-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}