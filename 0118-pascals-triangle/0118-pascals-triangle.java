class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            int ans=1;
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                ans*=(i-j);
                ans/=j;
                temp.add(ans);
            }
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}