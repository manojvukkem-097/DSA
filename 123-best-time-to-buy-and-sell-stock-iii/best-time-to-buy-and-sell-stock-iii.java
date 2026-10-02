class Solution {
    public int maxProfit(int[] prices) {
        int firstbuy=Integer.MIN_VALUE;
        int firstsell=0;
        int secondbuy=Integer.MIN_VALUE;
        int secondsell=0;
        for(int price:prices){
            firstbuy=Math.max(firstbuy,-price);
            firstsell=Math.max(firstsell,firstbuy+price);
            secondbuy=Math.max(secondbuy,firstsell-price);
            secondsell=Math.max(secondsell,secondbuy+price);
        }
        return secondsell;
    }
}