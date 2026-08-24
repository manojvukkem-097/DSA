class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer>map=new HashMap<>();
        int l=0,ans=0;
        for(int r=0;r<fruits.length;r++){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            if(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size()<=2){
                ans=Math.max(ans,r-l+1);
            }
        }
        return ans;
    }
}