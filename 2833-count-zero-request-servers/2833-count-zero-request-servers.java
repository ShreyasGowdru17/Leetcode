class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int left=0;
        int right=0;

        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));

        int[][] querys=new int[queries.length][2];

        for(int i=0;i<queries.length;i++){
            querys[i][0]=queries[i];
            querys[i][1]=i;
        }
        
        Arrays.sort(querys,(a,b)->Integer.compare(a[0],b[0]));
        int[] result=new int[queries.length];
        Map<Integer,Integer> activeServers=new HashMap<>();

        for(int[] quer:querys){

                while(right<logs.length && logs[right][1]<=quer[0]){
                    activeServers.put(logs[right][0],activeServers.getOrDefault(logs[right][0],0)+1);
                    right++;
                }

                while(left<logs.length && logs[left][1]<quer[0]-x){
                    activeServers.put(logs[left][0],activeServers.get(logs[left][0])-1);
                    if( activeServers.get(logs[left][0])==0){
                        activeServers.remove(logs[left][0]);
                    }
                    left++;
                }
                result[quer[1]]=n-activeServers.size();
        }
        return result;
    }
}