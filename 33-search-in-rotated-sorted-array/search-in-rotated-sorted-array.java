class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                if(nums[low]<target){
                    high=mid-1;
                }else if(nums[low]==target){
                    return low;
                }
                else if(nums[low]>target){
                    if(nums[high]>nums[mid]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
            }
            else if(nums[mid]<target){
                if(nums[low]>target){
                    low=mid+1;
                }else if(nums[low]==target){
                    return low;
                }else if(nums[low]<target){
                    if(nums[low]>nums[mid]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
            }
        }
        return -1;
    }
}