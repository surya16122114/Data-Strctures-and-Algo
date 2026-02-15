package Backtracking;

public class WordSearch {
    class Solution {
        public boolean exist(char[][] board, String word) {
            int rows=board.length;
            int cols=board[0].length;
            boolean[][] visited=new boolean[rows][cols];
    
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
    
                    if(board[i][j]==word.charAt(0)){
                        if(dfs(board, word, i, j, visited, 0, rows, cols))
                        return true;
                    }
    
                }
            }
    
    
            return false;
            
        }
    
    
        public boolean dfs(char[][] board, String word, int r, int c, boolean[][] visited, int index, int rows, int cols){
            if(index==word.length())
            return true;
    
            if(r<0 || r==rows || c<0 || c==cols || word.charAt(index)!=board[r][c] ||
            visited[r][c])
    
            return false;
    
    
            visited[r][c]=true;
    
    
           if( dfs(board, word, r+1, c, visited, index+1, rows, cols)
            ||  dfs(board, word, r, c+1, visited, index+1, rows, cols)
            || dfs(board, word, r-1, c, visited, index+1, rows, cols)
            ||  dfs(board, word, r, c-1, visited, index+1, rows, cols))return true;
    
            visited[r][c]=false;
    
            return false;
    
        }
    }
}
