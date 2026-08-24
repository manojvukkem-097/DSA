class Solution {
    public int totalFruit(int[] fruits) {
        int lastfruit=-1;
        int secondlast=-1;
        int currmax=0;
        int max=0;
        int lastfruitcount=0;
        for(int fruit:fruits){
            if(fruit==lastfruit||fruit==secondlast){
                currmax++;
            }else{
                currmax=lastfruitcount+1;
            }
            if(fruit==lastfruit){
                lastfruitcount++;
            }else{
                lastfruitcount=1;
                secondlast=lastfruit;
                lastfruit=fruit;
            }
            max=Math.max(max,currmax);
        }
        return max;
    }
}