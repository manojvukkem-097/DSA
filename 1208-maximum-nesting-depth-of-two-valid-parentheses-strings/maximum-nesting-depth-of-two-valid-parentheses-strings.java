class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[]ans=new int[seq.length()];
        int p=0;
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                ans[i]=p%2;
                p++;
            }else{
                p--;
                ans[i]=p%2;
            }
        }
        return ans;
    }
}