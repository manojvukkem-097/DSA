class Solution {
    public int longestValidParentheses(String s) {
        int ans=0;
        int[]st=new int[s.length()+1];
        int top=-1;
        st[++top]=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st[++top]=i;
            }else{
                top--;
                if(top==-1){
                    st[++top]=i;
                }else{
                    ans=Math.max(ans,i-st[top]);
                }
            }
        }
        return ans;
    }
}