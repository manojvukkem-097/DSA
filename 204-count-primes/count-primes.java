class Solution {
    public int countPrimes(int n) {
        boolean[]primes=new boolean[n];
        for(int i=2;i<n;i++){
            primes[i]=true;
        }
        for(int i=2;(long)i*i<n;i++){
            if(primes[i]){
                for(long j=i*i;j<n;j+=i){
                    if(primes[(int)j]){
                        primes[(int)j]=false;
                    }
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(primes[i]){
                count++;
            }
        }
        return count;
    }
}