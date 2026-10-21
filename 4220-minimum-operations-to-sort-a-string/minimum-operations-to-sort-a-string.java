class Solution {
    public int minOperations(String s) {
        int n=s.length();
        boolean issorted=true;
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)>s.charAt(i)){
                issorted=false;
                break;
            }
        }
        if(issorted)return 0;
        if(n==2)return -1;
        char min='z';
        char max='a';
        for(int i=0;i<n;i++){
            if(s.charAt(i)<min){
                min=s.charAt(i);
            }if(s.charAt(i)>max){
                max=s.charAt(i);
            }
        }
        if(min==s.charAt(0)||max==s.charAt(n-1))return 1;
        for(int i=1;i<n-1;i++){
            if(s.charAt(i)==min||s.charAt(i)==max){
                return 2;
            }
        }
        return 3;
    }
}