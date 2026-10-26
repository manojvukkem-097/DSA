class Solution {
    int MOD=1000000007;
    private int rev(int x){
        if(x<0){
            return x*10;
        }
        return (x%10)*10+x/10;
    }
    public int countPalindromes(String s) {
        int n=s.length();
        int[]fc=new int[10];
        int[]bc=new int[10];
        int[]fs=new int[100];
        int[]bs=new int[100];
        for(int i=n-1;i>=0;i--){
            int x=s.charAt(i)-'0';
            for(int j=0;j<10;j++){
                if(bc[j]>0){
                    bs[x*10+j]=(int)((bs[x*10+j]+(long)bc[j])%MOD);
                }
            }
            bc[x]++;
        }
        long ans=0;
        for(int i=0;i<n;i++){
            int x=s.charAt(i)-'0';
            bc[x]--;
            for(int j=0;j<10;j++){
                if(bc[j]>0){
                    bs[x*10+j]=(int)(bs[x*10+j]-(long)bc[j]+MOD)%MOD;
                }
            }
            for(int j=0;j<100;j++){
                if(fs[j]>0&&bs[rev(j)]>0){
                    ans=(ans+(long)fs[j]*bs[rev(j)])%MOD;
                }
            }
            for(int j=0;j<10;j++){
                if(fc[j]>0){
                    fs[j*10+x]=(int)((fs[j*10+x]+(long)fc[j])%MOD);
                }
            }
            fc[x]++;
        }
        return (int)ans;
    }
}