class Solution {
    private int findflp(int[]nums,int target,boolean isFirst){
        int low=0,high=nums.length-1,result=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                result=mid;
                if(isFirst){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        int[]ans={-1,-1};
        ans[0]=findflp(nums,target,true);
        ans[1]=findflp(nums,target,false);
        return ans;
    }
}