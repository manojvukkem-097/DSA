class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left=0,right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else if(s.charAt(i)==')'){
                if(left>0){
                    left--;
                }else{
                    right++;
                }
            }
        }
        Set<String>ans=new HashSet<>();
        backtrack(s,0,0,left,right,new StringBuilder(),ans);
        return new ArrayList<>(ans);
    }
    private void backtrack(String s,int index,int opencount,int left,int right,StringBuilder curr,Set<String>ans){
        if(index==s.length()){
            if(left==0&&right==0&&opencount==0){
                ans.add(curr.toString());
            }
            return;
        }
        char ch=s.charAt(index);
        int len=curr.length();
        if(ch=='('&&left>0){
            backtrack(s,index+1,opencount,left-1,right,curr,ans);
        }
        else if(ch==')'&&right>0){
            backtrack(s,index+1,opencount,left,right-1,curr,ans);
        }
        curr.append(ch);
        if(ch!='('&&ch!=')'){
            backtrack(s,index+1,opencount,left,right,curr,ans);
        }else if(ch=='('){
            backtrack(s,index+1,opencount+1,left,right,curr,ans);
        }else if(ch==')'&&opencount>0){
            backtrack(s,index+1,opencount-1,left,right,curr,ans);
        }
        curr.setLength(len);
    }
}