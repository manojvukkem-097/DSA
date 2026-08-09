class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(nums==null || nums.length<=1||nums.length==k||k==0){
            return;
        }
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    private void reverse(int[]nums,int low,int high){
        while(low<high){
            int temp=nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
    }
}