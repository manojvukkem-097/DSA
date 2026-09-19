class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xclose=Math.max(x1,Math.min(x2,xCenter));
        int yclose=Math.max(y1,Math.min(y2,yCenter));
        int dx=xclose-xCenter;
        int dy=yclose-yCenter;
        return dx*dx+dy*dy<=(radius*radius);
    }
}