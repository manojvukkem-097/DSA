class Solution {
    private int[]psee(int[]nums){
        int[]s=new int[nums.length];
        int top=-1;
        int[]ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(top!=-1&& nums[s[top]]>nums[i]){
                top--;
            }
            ans[i]=top!=-1?s[top]:-1;
            s[++top]=i;
        }
        return ans;
    }
     private int[]nse(int[]nums){
        int[]s=new int[nums.length];
        int top=-1;
        int[]ans=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(top!=-1 && nums[s[top]]>=nums[i]){
                top--;
            }
            ans[i]=top!=-1?s[top]:nums.length;
            s[++top]=i;
        }
        return ans;
    }
     private int[]pgee(int[]nums){
        int[]s=new int[nums.length];
        int top=-1;
        int[]ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(top!=-1&& nums[s[top]]<nums[i]){
                top--;
            }
            ans[i]=top!=-1?s[top]:-1;
            s[++top]=i;
        }
        return ans;
    }
     private int[]nge(int[]nums){
        int[]s=new int[nums.length];
        int top=-1;
        int[]ans=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(top!=-1&& nums[s[top]]<=nums[i]){
                top--;
            }
            ans[i]=top!=-1?s[top]:nums.length;
            s[++top]=i;
        }
        return ans;
    }
    public long subArrayRanges(int[] nums) {
        long smin=0;
        int[]previous=psee(nums);
        int[]next=nse(nums);
        for(int i=0;i<nums.length;i++){
            long left=i-previous[i];
            long right=next[i]-i;
            smin+=left*right*nums[i];
        }
        long smax=0;
        int[]prev=pgee(nums);
        int[]nex=nge(nums);
        for(int i=0;i<nums.length;i++){
            long left=i-prev[i];
            long right=nex[i]-i;
            smax+=left*right*nums[i];
        }
        return smax-smin;
    }
}