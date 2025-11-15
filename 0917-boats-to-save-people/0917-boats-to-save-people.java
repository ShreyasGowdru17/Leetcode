class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int maxCount=0;
        int left=0;
        int n=people.length;
        int right=n-1;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
                right--;
                maxCount++;
            }else{
                right--;
                maxCount++;
            }
        }
        return maxCount;
    }
}