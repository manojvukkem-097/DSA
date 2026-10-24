class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean[]prev=new boolean[n+1];
        boolean[]curr=new boolean[n+1];
        prev[0]=true;
        for(int j=1;j<=n;j++){
            boolean flag=true;
            for(int k=1;k<=j;k++){
                if(p.charAt(k-1)!='*'){
                    flag=false;
                    break;
                }
            }
            prev[j]=flag;
        }
        for(int i=1;i<=m;i++){
            curr[0]=false;
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    curr[j]=prev[j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    curr[j]=prev[j]||curr[j-1];
                }
                else curr[j]=false;
            }
            boolean[]temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[n];
    }
}