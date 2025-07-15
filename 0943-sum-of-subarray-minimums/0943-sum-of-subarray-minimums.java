class Solution {
    public int[] findNse(int[] arr){
        int[] result=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            result[i]= stack.isEmpty() ? arr.length:stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int[] findPsee(int[] arr){
        int[] result=new int[arr.length];
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty() ? -1:stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] nse=findNse(arr);
        int[] psee=findPsee(arr);
        int total=0;
        int mod=(int)1e9+7;
        for(int i=0;i<arr.length;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(total+(int)(arr[i]*1L*left%mod*right%mod))%mod;
        }
        return total;
    }
}