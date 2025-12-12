class Solution {
    private void removeSenator(String senate,char ch,boolean[] visited,int index){
        int n=senate.length();
        while(true){
            if(senate.charAt(index)==ch && visited[index]==false){
                visited[index]=true;
                break;
            }
            index=(index+1)%n;
        }
    }
    public String predictPartyVictory(String senate) {
        int rCount=0;
        int dCount=0;
        int n=senate.length();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R'){
                rCount++;
            }
        }
        dCount=n-rCount;
        int index=0;
        while(rCount>0 && dCount>0){
            if(visited[index]==false){
                if(senate.charAt(index)=='R'){
                    removeSenator(senate,'D',visited,(index+1)%n);
                    dCount--;
                }else{
                    removeSenator(senate,'R',visited,(index+1)%n);
                    rCount--;
                }
            }
            index=(index+1)%n;
        }
        return rCount==0?"Dire":"Radiant";
    }
}