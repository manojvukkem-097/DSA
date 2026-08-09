class Solution {
    public void nextPermutation(int[] nums) {
        int j=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                j=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(j==-1){
                break;
            }
            if(nums[j]<nums[i]){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                break;
            }
        }
        int r=nums.length-1;
        int l=j+1;
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}