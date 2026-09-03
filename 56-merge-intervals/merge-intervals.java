class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        List<int[]>result=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for(int[]interval:intervals){
            if(result.isEmpty()||result.get(result.size()-1)[1]<interval[0]){
                result.add(interval);
            }else{
                int end=Math.max(result.get(result.size()-1)[1],interval[1]);
                result.get(result.size()-1)[1]=end;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}