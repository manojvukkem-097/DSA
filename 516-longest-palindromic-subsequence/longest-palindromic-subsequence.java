class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1=s;
        String s2=new StringBuilder(s).reverse().toString();
        return lcs(s1,s2);
    }
    private int lcs(String s1,String s2){
        int m=s1.length(),n=s2.length();
        int[]prev=new int[n+1];
        for(int i=1;i<=m;i++){
            int[]curr=new int[n+1];
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }else{
                    curr[j]=Math.max(curr[j-1],prev[j]);
                }
            }
            prev=curr;
        }
        return prev[n];
    }
}