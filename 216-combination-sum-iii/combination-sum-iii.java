class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        helper(0,1,curr,ans,k,n);
        return ans;
    }
    private void helper(int sum,int idx,List<Integer>curr,List<List<Integer>>ans,int k,int n){
        if(sum==n && curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>n || curr.size()>=k||idx>9)return;
        curr.add(idx);
        helper(sum+idx,idx+1,curr,ans,k,n);
        curr.remove(curr.size()-1);
        helper(sum,idx+1,curr,ans,k,n);
    }
}