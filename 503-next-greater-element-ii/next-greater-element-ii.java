class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[]ans=new int[n];
        Stack<Integer>s=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!s.isEmpty()&&s.peek()<=nums[i%n]){
                s.pop();
            }
            if(i<n){
                ans[i]=s.isEmpty()?-1:s.peek();
            }
            s.push(nums[i%n]);
        }
        return ans;
    }
}