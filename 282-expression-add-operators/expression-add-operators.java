class Solution {
    public List<String> addOperators(String num, int target) {
        List<String>ans=new ArrayList<>();
        if(num==null||num.isEmpty())return ans;
        StringBuilder sb=new StringBuilder();
        helper(sb,0,0,0,num,target,ans);
        return ans;
    }
    private void helper(StringBuilder sb,int idx,long eval,long prev,String num,int target,List<String>ans){
        if(idx==num.length()){
            if(eval==target){
                ans.add(sb.toString());
            }
            return;
        }
        long currnum=0;
        int len=sb.length();
        for(int i=idx;i<num.length();i++){
            if(i>idx && num.charAt(idx)=='0')break;
            currnum=currnum*10+(num.charAt(i)-'0');
            if(idx==0){
                sb.append(currnum);
                helper(sb,i+1,currnum,currnum,num,target,ans);
                sb.setLength(len);
            }else{
                sb.append('+').append(currnum);
                helper(sb,i+1,eval+currnum,currnum,num,target,ans);
                sb.setLength(len);
                sb.append('-').append(currnum);
                helper(sb,i+1,eval-currnum,-currnum,num,target,ans);
                sb.setLength(len);
                sb.append('*').append(currnum);
                helper(sb,i+1,(eval-prev)+(prev*currnum),prev*currnum,num,target,ans);
                sb.setLength(len);
            }
        }
    }
}