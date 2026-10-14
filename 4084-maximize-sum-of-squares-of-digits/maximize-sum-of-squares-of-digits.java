class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9<sum||sum<0)return "";
        int k=sum/9;
        sum%=9;
        StringBuilder ans=new StringBuilder("9".repeat(k));
        if(sum>0){
            ans.append((char)(sum+'0'));
        }
        if(num-ans.length()>0)ans.append("0".repeat(num-ans.length()));
        return ans.toString();
    }
}