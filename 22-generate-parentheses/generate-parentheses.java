class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        generate("",0,0,ans,n);
        return ans;
    }
    private void generate(String a,int c1,int c2,List<String>ans,int n){
        if(a.length()==2*n){
            ans.add(a);
            return;
        }
        if(c1<n){
            generate(a+"(",c1+1,c2,ans,n);
        }
        if(c2<c1){
            generate(a+")",c1,c2+1,ans,n);
        }
    }
}