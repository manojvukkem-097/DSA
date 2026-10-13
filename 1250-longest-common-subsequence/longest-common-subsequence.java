class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[]prev=new int[text2.length()+1];
        for(int index1=1;index1<=text1.length();index1++){
            int[]curr=new int[text2.length()+1];
            for(int index2=1;index2<=text2.length();index2++){
                if(text1.charAt(index1-1)==text2.charAt(index2-1)){
                    curr[index2]=1+prev[index2-1];
                }
                else{
                    curr[index2]=Math.max(prev[index2],curr[index2-1]);
                }
            }
            prev=curr;
        }
        return prev[text2.length()];
    }
}