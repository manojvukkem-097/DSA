class Solution {
    public int countPrimes(int n) {
        if(n<=2)return 0;
        boolean[]composite=new boolean[n/2];
        int count=n/2;
        for(int i=3;i*i<n;i+=2){
            if(!composite[i/2]){
                for(int j=i*i;j<n;j+=2*i){
                    if(!composite[j/2]){
                        composite[j/2]=true;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}