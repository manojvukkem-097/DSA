class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans=new StringBuilder();
        int temp=0;
        for(int i=num;i>=0;i--){
            for(int j=9;j>=0;j--){
                if(temp+j==sum){
                    temp=temp+j;
                    ans.append((char)(j+'0'));
                    if(ans.length()==num)return ans.toString();
                }else if(temp+j<=sum){
                    temp=temp+j;
                    ans.append((char)(j+'0'));
                    break;
                }
            }
        }
        return "";
    }
}