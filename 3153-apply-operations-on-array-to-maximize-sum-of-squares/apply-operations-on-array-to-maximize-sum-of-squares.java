class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[]bitcount=new int[32];
        for(int num:nums){
            for(int i=0;i<32;i++){
                if((num &(1<<i))!=0){
                    bitcount[i]++;
                }
            }
        }
        long ans=0;
        long mod=1000000007;
        for(int i=0;i<k;i++){
            long currnum=0;
            for(int j=31;j>=0;j--){
                if(bitcount[j]>0){
                    currnum|=(1L<<j);
                    bitcount[j]--;
                }else{
                    continue;
                }
            }
            ans=(ans+(currnum*currnum)%mod)%mod;
        }
        return (int)ans;
    }
}