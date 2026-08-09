class Solution {
    public void moveZeroes(int[] nums) {
        int l=0;
        int r=1;
        while(l<nums.length && r<nums.length){
            if(nums[l]==0){
                if(nums[r]==0){
                    r++;
                }else{
                    int temp=nums[l];
                    nums[l]=nums[r];
                    nums[r]=temp; 
                }
            }
            else{
                l++;
                if(r<=l){
                    r=l+1;
                }
            }
        }
    }
}