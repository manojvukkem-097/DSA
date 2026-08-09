class Solution {
    public int myAtoi(String s) {
        if(s==null || s.isEmpty())return 0;
        s=s.trim();
        if(s.isEmpty())return 0;
        int i=0,symbol=1;
        long ans=0;
        char first=s.charAt(i);
        if(first=='+'){
            symbol=1;
            i++;
        }else if(first=='-'){
            symbol=-1;
            i++;
        }
        for(;i<s.length();i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                break;
            }else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                ans=ans*10+(s.charAt(i)-'0');
                if(symbol==1 && ans>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }if(symbol==-1 && -ans<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int)(symbol*ans);
    }
}