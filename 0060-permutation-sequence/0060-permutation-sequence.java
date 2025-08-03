class Solution {
    public String getPermutation(int n, int k) {
        int factorial=1;
        List<Integer> nums=new ArrayList<>();
        for(int i=1;i<n;i++){
            factorial*=i;
            nums.add(i);
        }
        nums.add(n);
        String ans="";
        k=k-1;
        while(true){
            ans=ans+Integer.toString(nums.get(k/factorial));
            nums.remove(k/factorial);
            if(nums.size()==0) break;
            k=k%factorial;
            factorial=factorial/nums.size();
        }
        return ans;
    }
}