class Solution {
    private boolean explore(char[][] board,String word,int index,int i,int j,int[][] visited){
        int m=board.length;
        int n=board[0].length;
        if(word.charAt(index)!=board[i][j]) return false;
        if(index==word.length()-1){
            return true;
        }

        
            visited[i][j]=1;
        boolean found=(i!=m-1 && visited[i+1][j]==0 && explore(board,word,index+1,i+1,j,visited)==true)||(j!=n-1 && visited[i][j+1]==0 && explore(board,word,index+1,i,j+1,visited)==true)||(j!=0 && visited[i][j-1]==0 && explore(board,word,index+1,i,j-1,visited)==true)||(i!=0 && visited[i-1][j]==0 &&  explore(board,word,index+1,i-1,j,visited)==true);
            visited[i][j]=0;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    int[][] visited=new int[m][n];
                    if(explore(board,word,0,i,j,visited)) return true;
                }
                
            }
        }
        return false;
    }
}