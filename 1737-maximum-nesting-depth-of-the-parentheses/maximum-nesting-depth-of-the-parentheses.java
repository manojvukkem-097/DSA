class Solution {
    public int maxDepth(String s) {
        int ans=0,p=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                p++;
                ans=Math.max(ans,p);
            }else if(s.charAt(i)==')'){
                p--;
            }
        }
        return Math.max(ans,p);
    }
}