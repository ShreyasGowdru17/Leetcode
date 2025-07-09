class Solution {
    public int myAtoi(String s) {

        s=s.trim();
        if(s.length()==0) return 0;

        int i=0;
        int sign=1;
        if(s.charAt(0)=='+'|| s.charAt(i)=='-'){
            if(s.charAt(0)=='-'){
                sign=sign*-1;
            }
            i++;
        }

        StringBuilder sb=new StringBuilder();
        int n=s.length();
        while(i<n && Character.isDigit(s.charAt(i))){
            sb.append(s.charAt(i));
            i++;
        }

        if(sb.length()==0) return 0;

        try{

            return sign*Integer.parseInt(sb.toString());
        }
        catch(Exception e){
            return sign==1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        
    }
}