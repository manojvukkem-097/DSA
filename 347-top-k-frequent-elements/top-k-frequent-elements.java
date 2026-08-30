class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>[]bucket=new List[nums.length+1];
        for(int key:map.keySet()){
            int freq=map.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int index=0;
        int[]ans=new int[k];
        for(int i=bucket.length-1;i>=0&&index<k;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    ans[index++]=num;
                    if(index==k)break;
                }
            }
        }
        return ans;
    }
}