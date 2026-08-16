class Solution {
    public int countPrimes(int n) {
        int[]primes=new int[n+1];
        for(int i=2;i<=n;i++){
            primes[i]=i;
        }
        for(int i=2;(long)i*i<=n;i++){
            if(primes[i]==i){
                for(long j=i*i;j<=n;j+=i){
                    if(primes[(int)j]==(int)j){
                        primes[(int)j]=i;
                    }
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(primes[i]==i){
                count++;
            }
        }
        return count;
    }
}