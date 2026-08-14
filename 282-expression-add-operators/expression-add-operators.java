class Solution {
    public List<String> addOperators(String num, int target) {
        List<String>ans=new ArrayList<>();
        if(num==null||num.isEmpty())return ans;
        helper("",0,0,0,num,target,ans);
        return ans;
    }
    private void helper(String curr,int idx,long eval,long prev,String num,int target,List<String>ans){
        if(idx==num.length()){
            if(eval==target){
                ans.add(curr);
            }
            return;
        }
        for(int i=idx;i<num.length();i++){
            if(i>idx && num.charAt(idx)=='0')break;
            long currnum=Long.parseLong(num.substring(idx,i+1));
            if(idx==0){
                helper(curr+currnum,i+1,currnum,currnum,num,target,ans);
            }else{
                helper(curr+"+"+currnum,i+1,eval+currnum,currnum,num,target,ans);
                helper(curr+"-"+currnum,i+1,eval-currnum,-currnum,num,target,ans);
                helper(curr+"*"+currnum,i+1,(eval-prev)+(prev*currnum),prev*currnum,num,target,ans);
            }
        }
    }
}