public class NumberOfIslands {
    class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int r, int c, int rows, int cols){
        if(r<0 || c<0 || r>=rows || c>=cols || grid[r][c]=='0')
        return;
        grid[r][c]='0';
        dfs(grid, r, c-1, rows, cols);
        dfs(grid, r-1, c, rows, cols);
        dfs(grid, r, c+1, rows, cols);
        dfs(grid, r+1, c, rows, cols);
    }
}
}
