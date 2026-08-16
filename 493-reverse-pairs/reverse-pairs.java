class Solution {
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }
    private int mergesort(int[]nums,int low,int high){
        int count=0;
        if(low<high){
            int mid=low+(high-low)/2;
            count+=mergesort(nums,low,mid);
            count+=mergesort(nums,mid+1,high);
            count+=countpairs(nums,low,mid,high);
            merge(nums,low,mid,high);
        }
        return count;
    }
    private int countpairs(int[]nums,int low,int mid,int high){
        int right=mid+1,count=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && nums[i]>2*(long)nums[right]){
                right++;
            }
            count+=(right-(mid+1));
        }
        return count;
    }
    private void merge(int[]nums,int low,int mid,int high){
        int idx1=low,idx2=mid+1,x=0;
        int[]merged=new int[high-low+1];
        while(idx1<=mid && idx2<=high){
            if(nums[idx1]>=nums[idx2]){
                merged[x++]=nums[idx2++];
            }else{
                merged[x++]=nums[idx1++];
            }
        }
        while(idx1<=mid){
            merged[x++]=nums[idx1++];
        }
        while(idx2<=high){
            merged[x++]=nums[idx2++];
        }
        for(int i=low;i<=high;i++){
            nums[i]=merged[i-low];
        }
    }
}