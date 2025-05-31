import java.util.Arrays;
class Solution {
    public boolean canWeMake(int[] position,int mid,int m){
            int countCow=1;
            int coord=0;
            for(int i=0;i<position.length;i++){
                if(position[i]-position[coord]>=mid){
                    countCow++;
                    coord=i;
                }
            }
            if(countCow>=m){
                return true;
            }
            return false;
        }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left=0;
        int right=position[position.length-1]-position[0];
        while(left<=right){
            int mid=(left+right)/2;
            if(canWeMake(position,mid,m)){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return right;
    }
}