class Solution {
    public int candy(int[] ratings) {
        if(ratings.length<=1)return ratings.length;
        int[]temp=new int[ratings.length];
        Arrays.fill(temp,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                temp[i]=temp[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                temp[i]=Math.max(temp[i],temp[i+1]+1);
            }
        }
        int ans=0;
        for(int num:temp){
            ans+=num;
        }
        return ans;
    }
}