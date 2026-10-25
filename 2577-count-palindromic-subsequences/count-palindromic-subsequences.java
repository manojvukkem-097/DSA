class Solution {
    int MOD=1000000007;
    public int countPalindromes(String s) {
        int n=s.length();
        int[][][][]dp=new int[n+1][6][11][11];
        for(int i=0;i<=n;i++){
            for(int d1=0;d1<11;d1++){
                for(int d2=0;d2<11;d2++){
                    dp[i][5][d1][d2]=1;
                }
            }
        }
        for(int index=n-1;index>=0;index--){
            int curr=s.charAt(index)-'0';
            for(int matchcount=5;matchcount>=0;matchcount--){
                for(int d1=9;d1>=0;d1--){
                    for(int d2=9;d2>=0;d2--){
                        int totalcount=0;
                        totalcount+=dp[index+1][matchcount][d1][d2]%MOD;
                        if(matchcount==0){
                            totalcount+=dp[index+1][1][curr][d2]%MOD;
                        }else if(matchcount==1){
                            totalcount+=dp[index+1][2][d1][curr]%MOD;
                        }else if(matchcount==2){
                            totalcount+=dp[index+1][3][d1][d2]%MOD;
                        }else if(matchcount==3){
                            if(curr==d2){
                                totalcount+=dp[index+1][4][d1][d2]%MOD;
                            }
                        }else if(matchcount==4){
                            if(curr==d1){
                                totalcount+=dp[index+1][5][d1][d2]%MOD;
                            }
                        }
                        dp[index][matchcount][d1][d2]=totalcount%MOD;
                    }
                }
            }
        }
        return dp[0][0][0][0];
    }
}