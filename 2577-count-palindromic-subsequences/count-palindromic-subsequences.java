class Solution {
    int MOD=1000000007;
    public int countPalindromes(String s) {
        int n=s.length();
        int[][][][]dp=new int[n][5][10][10];
        for(int[][][]grid:dp){
            for(int[][]row:grid){
                for(int[]col:row){
                    Arrays.fill(col,-1);
                }
            }
        }
        return helper(s,0,0,0,0,dp);
    }
    private int helper(String s,int index,int matchcount,int d1,int d2,int[][][][]dp){
        if(matchcount==5){
            return 1;
        }
        if(index==s.length()){
            return 0;
        }
        if(dp[index][matchcount][d1][d2]!=-1)return dp[index][matchcount][d1][d2];
        int totalcount=0;
        int curr=s.charAt(index)-'0';
        totalcount+=helper(s,index+1,matchcount,d1,d2,dp)%MOD;
        if(matchcount==0){
            totalcount+=helper(s,index+1,1,curr,d2,dp)%MOD;
        }else if(matchcount==1){
            totalcount+=helper(s,index+1,2,d1,curr,dp)%MOD;
        }else if(matchcount==2){
            totalcount+=helper(s,index+1,3,d1,d2,dp)%MOD;
        }else if(matchcount==3){
            if(curr==d2){
                totalcount+=helper(s,index+1,4,d1,d2,dp)%MOD;
            }
        }else if(matchcount==4){
            if(curr==d1){
                totalcount+=helper(s,index+1,5,d1,d2,dp)%MOD;
            }
        }
        return dp[index][matchcount][d1][d2]=totalcount%MOD;
    }
}