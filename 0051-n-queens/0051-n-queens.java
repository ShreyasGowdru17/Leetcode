class Solution {
    private void queens(int n,int col,int[] leftRow,int[] upperDiagonal,int[] lowerDiagonal,List<List<String>> result,List<String> board){
        if(col==n){
            result.add(new ArrayList<>(board));
            return;
        }

        for(int row=0;row<n;row++){

            if(leftRow[row]==0 && upperDiagonal[row+col]==0 && lowerDiagonal[(n-1)+col-row]==0){
                char[] curRow=board.get(row).toCharArray();
                curRow[col]='Q';
                board.set(row,new String(curRow));
                leftRow[row]=1;
                upperDiagonal[row+col]=1;
                lowerDiagonal[(n-1)+col-row]=1;
                queens(n,col+1,leftRow,upperDiagonal,lowerDiagonal,result,board);
                curRow[col]='.';
                board.set(row,new String(curRow));
                leftRow[row]=0;
                upperDiagonal[row+col]=0;
                lowerDiagonal[(n-1)+col-row]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        List<String> board=new ArrayList<>();
        String s=".".repeat(n);
        for(int i=0;i<n;i++){
            board.add(s);
        }
        int[] leftRow=new int[n];
        int[] upperDiagonal=new int[2*n-1];
        int[] lowerDiagonal=new int[2*n-1];
        queens(n,0,leftRow,upperDiagonal,lowerDiagonal,result,board);
        return result;
    }
}