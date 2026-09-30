class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer>set=new HashSet<>();
        int required=candyType.length/2,count=0;
        for(int candy:candyType){
            if(required==0)return count;
            if(!set.contains(candy)){
                set.add(candy);
                required--;
                count++;
            }
        }
        return count;
    }
}