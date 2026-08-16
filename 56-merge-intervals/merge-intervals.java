class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]>ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int currstart=intervals[i][0];
            int currend=intervals[i][1];
            if(currstart<=end){
                end=Math.max(end,currend);
            }else{
                ans.add(new int[]{start,end});
                start=currstart;
                end=currend;
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}