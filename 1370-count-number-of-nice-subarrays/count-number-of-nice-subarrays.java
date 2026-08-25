class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[]count=new int[nums.length+1];
        count[0]=1;
        int l=0,sum=0,ans=0;
        for(int num:nums){
            sum+=num&1;
            if(sum>=k){
                ans+=count[sum-k];
            }
            count[sum]++;
        }
        return ans;
    }
}