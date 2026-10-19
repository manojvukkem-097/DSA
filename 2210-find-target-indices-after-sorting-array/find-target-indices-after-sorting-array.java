class Solution {
    private int search(int[]nums,int target,boolean isfirst){
        int si=0,ei=nums.length-1,ans=-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(nums[mid]==target){
                ans=mid;
                if(isfirst){
                    ei=mid-1;
                }else{
                    si=mid+1;
                }
            }else if(nums[mid]<target){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        return ans;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int si=search(nums,target,true);
        int ei=search(nums,target,false);
        List<Integer>ans=new ArrayList<>();
        if(si==-1)return ans;
        for(int i=si;i<=ei;i++){
            ans.add(i);
        }
        return ans;
    }
}