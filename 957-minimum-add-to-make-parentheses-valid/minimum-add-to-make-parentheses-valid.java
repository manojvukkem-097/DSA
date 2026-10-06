class Solution {
    public int minAddToMakeValid(String s) {
        int ans=0,open=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(open<0){
                    ans+=Math.abs(open);
                    open=0;
                }
                open++;
            }else{
                open--;
            }
        }
        ans+=Math.abs(open);
        return ans;
    }
}