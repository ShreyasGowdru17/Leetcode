class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> freq=new HashMap<>();
        int n=arr.length;
        for(int num:arr){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        int count=0;
        for(int ele:freq.values()){
            list.add(ele);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(k>list.get(i)){
                k-=list.get(i);
                list.set(i,0);
            }else{
                list.set(i,list.get(i)-k);
                k=0;
            }
            if(list.get(i)!=0) count++;
        }
        return count;
    }
}