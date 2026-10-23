class Solution {
    public int sortPermutation(int[] nums) {
        boolean issorted=true;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                issorted=false;
                break;
            }
        }
        if(issorted)return 0;
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                if(ans==-1){
                    ans=nums[i];
                }else{
                    ans&=nums[i];
                }
            }
        }
        return ans;
    }
}