class Solution {
    public int searchInsert(int[] nums, int target) {
        int si=0,ei=nums.length-1,pos=nums.length;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                pos=mid;
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return pos;
    }
}