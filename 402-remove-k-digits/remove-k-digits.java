class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length())return "0";
        char[]s=new char[num.length()];
        int top=-1;
        for(int i=0;i<num.length();i++){
            char curr=num.charAt(i);
            while(top!=-1 &&k!=0 && s[top]>curr){
                top--;
                k--;
            }
            s[++top]=curr;
        }
        while(k>0 && top!=-1){
            top--;
            k--;
        }
        StringBuilder ans=new StringBuilder();
        while(top!=-1){
            ans.append(s[top--]);
        }
        ans.reverse();
        int start=0;
        while(start<ans.length() && ans.charAt(start)=='0'){
            start++;
        }
        String result=ans.substring(start);
        return result.isEmpty()?"0":result;
    }
}