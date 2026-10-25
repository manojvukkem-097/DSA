class Solution {
    int MOD=1000000007;
    public int countPalindromes(String s) {
        int n=s.length();
        //int[][][][]dp=new int[n+1][6][11][11];
        int[][][]next=new int[6][11][11];
        int[][][]curr=new int[6][11][11];
        for(int d1=0;d1<11;d1++){
            for(int d2=0;d2<11;d2++){
                next[5][d1][d2]=1;
            }
        }
        for(int index=n-1;index>=0;index--){
            int current=s.charAt(index)-'0';
            for(int matchcount=5;matchcount>=0;matchcount--){
                for(int d1=9;d1>=0;d1--){
                    for(int d2=9;d2>=0;d2--){
                        int totalcount=0;
                        totalcount+=next[matchcount][d1][d2]%MOD;
                        if(matchcount==0){
                            totalcount+=next[1][current][d2]%MOD;
                        }else if(matchcount==1){
                            totalcount+=next[2][d1][current]%MOD;
                        }else if(matchcount==2){
                            totalcount+=next[3][d1][d2]%MOD;
                        }else if(matchcount==3){
                            if(current==d2){
                                totalcount+=next[4][d1][d2]%MOD;
                            }
                        }else if(matchcount==4){
                            if(current==d1){
                                totalcount+=next[5][d1][d2]%MOD;
                            }
                        }
                        curr[matchcount][d1][d2]=totalcount%MOD;
                    }
                }
            }
            for(int j=0;j<6;j++){
                for(int k=0;k<11;k++){
                    for(int l=0;l<11;l++){
                        next[j][k][l]=curr[j][k][l];
                    }
                }
            }
        }
        return next[0][0][0];
    }
}