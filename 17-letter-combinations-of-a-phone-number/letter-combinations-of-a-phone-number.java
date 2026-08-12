class Solution {
    public List<String> letterCombinations(String digits) {
        String[]keypad={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String>ans=new ArrayList<>();
        if(digits==null || digits.length()==0)return ans;
        helper("",0,digits,ans,keypad);
        return ans;
    }
    private void helper(String s,int idx,String digits,List<String>ans,String[]keypad){
        if(idx==digits.length()){
            ans.add(s);
            return;
        }
        String curr=keypad[digits.charAt(idx)-'2'];
        for(int i=0;i<curr.length();i++){
            helper(s+curr.charAt(i),idx+1,digits,ans,keypad);
        }
    }
}