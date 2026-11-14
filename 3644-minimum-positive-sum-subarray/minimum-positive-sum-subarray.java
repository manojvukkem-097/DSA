class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int ans=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int sum=0,j=0,k=0;
            while(j<n&&k<n){
                if(k-j+1>i){
                    if(sum>0){
                        ans=Math.min(ans,sum);
                    }
                    sum-=nums.get(j);
                    sum+=nums.get(k);
                    j++;
                    k++;
                }else{
                    sum+=nums.get(k);
                    k++;
                }
            }
            if(sum>0){
                ans=Math.min(ans,sum);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}