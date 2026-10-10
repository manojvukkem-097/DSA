class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k=(long)k1+k2;
        int n=nums1.length;
        int[]count=new int[100001];
        int maxdiff=0;
        for(int i=0;i<n;i++){
            int diff=Math.abs(nums1[i]-nums2[i]);
            count[diff]++;
            maxdiff=Math.max(maxdiff,diff);
        }
        for(int i=maxdiff;i>0;i--){
            if(count[i]>0){
                long take=Math.min(count[i],k);
                count[i]-=take;
                count[i-1]+=take;
                k-=take;
                if(k==0)break;
            }
        }
        long ans=0;
        for(int i=0;i<=maxdiff;i++){
            if(count[i]>0){
                ans+=(long)count[i]*i*i;
            }
        }
        return ans;
    }
}