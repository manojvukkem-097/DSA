class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int currsum=0,n=cardPoints.length;
        for(int i=0;i<k;i++){
            currsum+=cardPoints[i];
        }
        int maxsum=currsum;
        for(int i=1;i<=k;i++){
            currsum+=cardPoints[n-i]-cardPoints[k-i];
            maxsum=Math.max(maxsum,currsum);
        }
        return maxsum;
    }
}