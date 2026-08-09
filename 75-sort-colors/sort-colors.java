class Solution {
    public void sortColors(int[] nums) {
        int i=0,si=0,ei=nums.length-1;
        while(i<=ei){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[si];
                nums[si]=temp;
                i++;
                si++;
            }
            else if(nums[i]==2){
                int temp=nums[i];
                nums[i]=nums[ei];
                nums[ei]=temp;
                ei--;
            }
            else{
                i++;
            }
        }
    }
}