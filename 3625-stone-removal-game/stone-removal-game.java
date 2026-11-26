class Solution {
    public boolean canAliceWin(int n) {
        int count=0;
        for(int i=10;i>0;i--){
            count++;
            if(n-i<0){
                if(count%2!=0){
                    return false;
                }
                return true;
            }
            n-=i;
        }
        return true;
    }
}