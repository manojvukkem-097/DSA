class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        Arrays.sort(nums);
        helper(0,curr,ans,nums);
        return ans;
    }
    private void helper(int idx,List<Integer>curr,List<List<Integer>>ans,int[]nums){
        ans.add(new ArrayList<>(curr));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])continue;
            curr.add(nums[i]);
            helper(i+1,curr,ans,nums);
            curr.remove(curr.size()-1);
        }
    }
}