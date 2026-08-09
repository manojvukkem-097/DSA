class Solution {
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        return (int)((pow(5,even)*pow(4,odd))%1000000007);
    }
    private long pow(long x,long N){
        long ans=1;
        while(N>0){
            if(N%2==1){
                ans=(ans*x)%1000000007;
            }
            x=(x*x)%1000000007;
            N=N/2;
        }
        return ans%1000000007;
    }
}