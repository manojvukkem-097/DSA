class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        Integer[]after=new Integer[n];
        Map<Integer,Integer>map=new HashMap<>(n);
        for(int i=0;i<n;i++){
            after[i]=nums[i];
            map.put(nums[i],i);
        }
        Arrays.sort(after,(a,b)->{
            int suma=sumdigits(a);
            int sumb=sumdigits(b);
            if(suma!=sumb){
                return suma-sumb;
            }
            return a-b;
        });
        int ans=0;
        for(int i=0;i<n;i++){
            int expected=after[i];
            if(nums[i]==expected)continue;
            int idx=map.get(after[i]);
            int temp=nums[i];
            nums[i]=nums[idx];
            nums[idx]=temp;
            map.put(temp,idx);
            map.put(nums[i],i);
            ans++;
        }
        return ans;
    }
    private int sumdigits(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}