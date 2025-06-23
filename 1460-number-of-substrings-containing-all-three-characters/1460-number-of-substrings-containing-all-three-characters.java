class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] array=new int[3];
        array[0]=array[1]=array[2]=-1;
        int count=0;
        for(int right=0;right<s.length();right++){
            array[s.charAt(right)-'a']=right;
            if(array[0]!=-1 && array[1]!=-1 && array[2]!=-1){
                count+=Math.min(array[0],Math.min(array[1],array[2]));
                count++;
            }
        }
        return count;
    }
}