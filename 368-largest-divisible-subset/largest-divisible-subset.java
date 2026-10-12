class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[]dp=new int[nums.length];
        int[]hash=new int[nums.length];
        Arrays.fill(dp,1);
        int len=1,maxi=0;
        for(int i=0;i<nums.length;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        hash[i]=j;
                    }
                }
            }
            if(len<dp[i]){
                len=dp[i];
                maxi=i;
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(hash[maxi]!=maxi){
            ans.add(nums[maxi]);
            maxi=hash[maxi];
        }
        ans.add(nums[maxi]);
        return ans;
    }
}