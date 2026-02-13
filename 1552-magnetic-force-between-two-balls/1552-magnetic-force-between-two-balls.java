class Solution {
    private boolean canWeMake(int[] position,int m,int mid){
            int count=1;
            int n=position.length;
            int lastPos=0;
            for(int i=1;i<n;i++){
                if(position[i]-position[lastPos]>=mid){
                    lastPos=i;
                    count++;
                }
            }
            if(count>=m){
                return true;
            }
            return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int left=0;
        int right=position[n-1]-position[0];
        int ans=-1;

        while(left<=right){

            int mid=(left+right)/2;
            if(canWeMake(position,m,mid)){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return ans;
    }
}