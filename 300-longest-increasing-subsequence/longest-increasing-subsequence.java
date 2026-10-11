class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums== null||nums.length==0)return 0;
        List<Integer>bs=new ArrayList<>();
        bs.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>bs.get(bs.size()-1)){
                bs.add(nums[i]);
            }else{
                int index=getindex(nums[i],bs);
                bs.set(index,nums[i]);
            }
        }
        return bs.size();
    }
    private int getindex(int num,List<Integer>bs){
        int low=0,high=bs.size()-1;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(num<=bs.get(mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}