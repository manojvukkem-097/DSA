class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    private int atmost(int[]nums,int k){
        if(k<0)return 0;
        int l=0,ans=0,count=0;
        for(int r=0;r<nums.length;r++){
            count+=nums[r]%2==0?0:1;
            while(count>k){
                count-=nums[l++]%2==0?0:1;
            }
            ans+=r-l+1;
        }
        return ans;
    }
}