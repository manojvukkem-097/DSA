class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        char[]s=new char[2*n];
        generate(s,0,0,0,ans,n);
        return ans;
    }
    private void generate(char[]s,int c1,int c2,int pos,List<String>ans,int n){
        if(pos==s.length){
            ans.add(new String(s));
            return;
        }
        if(c1<n){
            s[pos]='(';
            generate(s,c1+1,c2,pos+1,ans,n);
        }
        if(c2<c1){
            s[pos]=')';
            generate(s,c1,c2+1,pos+1,ans,n);
        }
    }
}