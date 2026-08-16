class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>row=new ArrayList<>();
        row.add(1);
        result.add(row);
        List<Integer>prev=row;
        for(int i=1;i<numRows;i++){
            List<Integer>curr=new ArrayList<>();
            curr.add(1);
            for(int j=1;j<i;j++){
                curr.add(prev.get(j)+prev.get(j-1));
            }
            curr.add(1);
            result.add(curr);
            prev=curr;
        }
        return result;
    }
}