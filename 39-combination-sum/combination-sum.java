class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        helper(0,0,curr,ans,candidates,target);
        return ans;
    }
    private void helper(int idx,int sum,List<Integer>curr,List<List<Integer>>ans,int[]nums,int k){
        if(idx>=nums.length || sum>k)return;
        if(sum==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        helper(idx,sum+nums[idx],curr,ans,nums,k);
        curr.remove(curr.size()-1);
        helper(idx+1,sum,curr,ans,nums,k);
    }
}