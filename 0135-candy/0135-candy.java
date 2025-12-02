class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] lr=new int[n];
        for(int i=0;i<n;i++){
            lr[i]=1;
        }
        int[] rl=new int[n];
        for(int i=0;i<n;i++){
            rl[i]=1;
        }
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                lr[i]=Math.max(lr[i],lr[i-1]+1);
            }
        }

         for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                rl[i]=Math.max(rl[i],rl[i+1]+1);
            }
        }

        int candy=0;
        for(int i=0;i<n;i++){
            candy+=Math.max(lr[i],rl[i]);
        }
        return candy;
    }
}