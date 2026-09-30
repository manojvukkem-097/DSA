class Solution {
    private boolean isvalid(String seq){
        Stack<Character>s=new Stack<>();
        for(char ch:seq.toCharArray()){
            if(ch=='('){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                s.pop();
            }
        }
        return s.isEmpty();
    }
    public int[] maxDepthAfterSplit(String seq) {
        if(!isvalid(seq)){
            return new int[]{};
        }
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