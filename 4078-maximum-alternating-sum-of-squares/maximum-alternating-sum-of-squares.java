class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans=0;
        int maxi=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0)nums[i]*=-1;
            maxi=Math.max(maxi,nums[i]);
        }
        int[]freq=new int[maxi+1];
        for(int x:nums){
            freq[x]++;
        }
        int l=0,r=maxi;
        while(l<r){
            while(l<r&&freq[l]==0)l++;
            while(l<r&&freq[r]==0)r--;
            if(l>=r)break;
            int cnt=Math.min(freq[l],freq[r]);
            freq[l]-=cnt;
            freq[r]-=cnt;
            long diff=(long)r*r-l*l;
            ans+=diff*cnt;
        }
        if(l==r&&freq[r]>0){
            if((freq[r]&1)!=0){
                ans+=(long)r*r;
            }
        }
        return ans;
    }
}