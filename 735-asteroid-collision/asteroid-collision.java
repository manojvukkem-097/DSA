class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[]s=new int[asteroids.length];
        int top=-1;
        for(int a:asteroids){
            boolean destroyed=false;
            while(top!=-1 &&(s[top]>0 && a<0)){
                if(s[top]>-a){
                    destroyed=true;
                    break;
                }else if(s[top]==-a){
                    top--;
                    destroyed=true;
                    break;
                }else{
                    top--;
                }
            }
            if(!destroyed){
                s[++top]=a;
            }
        }
        int[]ans=new int[top+1];
        for(int i=top;i>=0;i--){
            ans[i]=s[top--];
        }
        return ans;
    }
}