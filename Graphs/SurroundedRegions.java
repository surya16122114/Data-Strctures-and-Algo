public class SurroundedRegions {
    class Solution {
        public void solve(char[][] board) {
            int rows=board.length;
            int cols=board[0].length;
    //temporary conversion of border Os to some F
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(board[i][j]=='O' && (i==0 || i==rows-1 || j==0 || j==cols-1))
                    dfs(board, i, j, rows, cols);
                }
            }
    
                //Now look for the Os in the middle so if they are not connected to the border Os we can convert these Os to X
    
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O')
                board[i][j]='X';
            }
        }
    //Now conver the temp F s back to O s
          for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='F')
                board[i][j]='O';
            }
        }
        }
    
    
    
    //Dfs for the border Os
        public void dfs(char[][] board, int i, int j, int rows, int cols){
            if(i<0 || j<0 || i==rows || j==cols || board[i][j]!='O')
            return ;
            board[i][j]='F';
            dfs(board, i, j+1, rows, cols);
            dfs(board, i, j-1, rows, cols);
            dfs(board, i-1, j, rows, cols);
            dfs(board, i+1, j, rows, cols);
        }
    }
}
