class Solution {
    private String addStrings(String num1,String num2){
        StringBuilder sb=new StringBuilder();
        int carry=0;
        int i=num1.length()-1;
        int j=num2.length()-1;

        while(i>=0 || j>=0 || carry!=0){
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;

            int sum=x+y+carry;
            sb.append(sum%10);
            carry=sum/10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
    private boolean backtrack(String num,List<String> path,int index) {
        if(index==num.length()){
            return path.size()>=3;
        }
        
        for(int i=index+1;i<=num.length();i++){
            String part=num.substring(index,i);

            if(part.length()>1 && part.charAt(0)=='0') continue;

            int size=path.size();
            if(size>=2){
                String sum=addStrings(path.get(size-1),path.get(size-2));
                if(!part.equals(sum)) continue;
            }
            path.add(part);
            if(backtrack(num,path,i))return true;
            path.remove(path.size()-1);
        }
        return false;
    }
    public boolean isAdditiveNumber(String num) {
        return backtrack(num,new ArrayList<>(),0);
    }

}