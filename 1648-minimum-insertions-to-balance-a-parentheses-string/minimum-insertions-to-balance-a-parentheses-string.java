class Solution {
    public int minInsertions(String s) {
        int open=0,ans=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(open%2!=0){
                    ans++;
                    open--;
                }
                open+=2;
            }else{
                open--;
                if(open<0){
                    ans++;
                    open+=2;
                }
            }
        }
        return ans+open;
    }
}