class Solution {
    private int[]pse(int[]heights){
        int[]s=new int[heights.length];
        int top=-1;
        int[]ans=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(top!=-1&& heights[s[top]]>=heights[i]){
                top--;
            }
            ans[i]=top==-1?-1:s[top];
            s[++top]=i;
        }
        return ans;
    }
    private int[]nse(int[]heights){
        int[]s=new int[heights.length];
        int top=-1;
        int[]ans=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            while(top!=-1&& heights[s[top]]>=heights[i]){
                top--;
            }
            ans[i]=top==-1?heights.length:s[top];
            s[++top]=i;
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[]previous=pse(heights);
        int[]next=nse(heights);
        int ans=0;
        for(int i=0;i<heights.length;i++){
            ans=Math.max(ans,(next[i]-previous[i]-1)*heights[i]);
        }
        return ans;
    }
}