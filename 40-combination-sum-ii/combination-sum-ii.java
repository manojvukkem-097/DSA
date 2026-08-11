class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,0,curr,ans,candidates,target);
        return ans;
    }
    private void helper(int idx,int sum,List<Integer>curr,List<List<Integer>>ans,int[]nums,int k){
        if(sum==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>k||idx>=nums.length)return;
        curr.add(nums[idx]);
        helper(idx+1,sum+nums[idx],curr,ans,nums,k);
        curr.remove(curr.size()-1);
        while(idx+1<nums.length && nums[idx]==nums[idx+1]){
            idx++;
        }
        helper(idx+1,sum,curr,ans,nums,k);
    }
}