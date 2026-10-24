class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[]days=new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int Aliceam=Integer.parseInt(arriveAlice.substring(0,2));
        int Alicead=Integer.parseInt(arriveAlice.substring(3));
        int Alicelm=Integer.parseInt(leaveAlice.substring(0,2));
        int Aliceld=Integer.parseInt(leaveAlice.substring(3));
        int bobam=Integer.parseInt(arriveBob.substring(0,2));
        int bobad=Integer.parseInt(arriveBob.substring(3));
        int boblm=Integer.parseInt(leaveBob.substring(0,2));
        int bobld=Integer.parseInt(leaveBob.substring(3));
        int ans=0,monthstart=-1,monthend=-1,daystart=-1,dayend=-1;
        if(Aliceam==bobam){
            monthstart=Aliceam;
            daystart=Math.max(Alicead,bobad);
        }else{
            monthstart=Math.max(Aliceam,bobam);
            if(monthstart==Aliceam){
                daystart=Alicead;
            }else{
                daystart=bobad;
            }
        }
        if(Alicelm==boblm){
            monthend=Alicelm;
            dayend=Math.min(Aliceld,bobld);
        }else{
            monthend=Math.min(Alicelm,boblm);
            if(monthend==Alicelm){
                dayend=Aliceld;
            }else{
                dayend=bobld;
            }
        }
        if(Alicelm<bobam||boblm<Aliceam)return 0;
        if(monthstart==monthend&&daystart>dayend)return 0;
        if(monthstart==monthend)return dayend-daystart+1;
        ans+=days[monthstart]-daystart+1;
        for(int i=monthstart+1;i<monthend;i++){
            ans+=days[i];
        }
        ans+=dayend;
        return ans;
    }
}