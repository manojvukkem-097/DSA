class Solution {
    public long maxAlternatingSum(int[] nums) {
        Integer[]boxednums=Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxednums,(a,b)->Math.abs(a)-Math.abs(b));
        int l=0,r=boxednums.length-1;
        long ans=0;
        while(l<=r){
            long val;
            if(l==r){
                val=boxednums[r];
                ans+=val*val;
                break;
            }
            long maxval=boxednums[r];
            ans+=maxval*maxval;
            r--;
            long minval=boxednums[l];
            ans-=minval*minval;
            l++;
        }
        return ans;
    }
}