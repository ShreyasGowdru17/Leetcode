class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int curCapacity=capacity;
        int steps=0;
        int n=plants.length;
        for(int i=0;i<n;i++){
            if(plants[i]<=curCapacity){
                steps++;
            }else{
                curCapacity=capacity;
                steps+=i+i+1;
            }
            curCapacity-=plants[i];
        }
        return steps;
    }
}