class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int rev=0;
        int dup=x;
        while(dup!=0){
            int r=dup%10;
            rev=rev*10+r;
            dup=dup/10;
        }
        if(rev==x){
            return true;
        }
        return false;
    }
}