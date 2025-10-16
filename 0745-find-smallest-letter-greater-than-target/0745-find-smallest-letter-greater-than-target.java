class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left=0;
        int right=letters.length-1;
        int lowerBound=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(letters[mid]>target){
                right=mid-1;
                lowerBound=mid;
            }else{
                left=mid+1;
            }
        }
        return letters[lowerBound];
    }
}