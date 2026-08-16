class Solution {
    public int minBitFlips(int start, int goal) {
        int bitmask=start^goal;
        int count=0;
        while(bitmask>0){
            bitmask&=(bitmask-1);
            count++;
        }
        return count;
    }
}