class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[]ans=new int[n];
        int[]s=new int[n];
        int top=-1;
        for(int i=2*n-1;i>=0;i--){
            while(top!=-1&&s[top]<=nums[i%n]){
                top--;
            }
            if(i<n){
                ans[i]=top==-1?-1:s[top];
            }
            top++;
            s[top]=nums[i%n];
        }
        return ans;
    }
}