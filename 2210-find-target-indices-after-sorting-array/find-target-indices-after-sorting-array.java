class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int countless=0;
        int targetcount=0;
        for(int num:nums){
            if(num<target){
                countless++;
            }else if(num==target){
                targetcount++;
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<targetcount;i++){
            ans.add(i+countless);
        }
        return ans;
    }
}