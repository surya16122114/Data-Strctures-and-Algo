import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticFlow {
    class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        List<List<Integer>> res=new ArrayList<>();
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic =new boolean[m][n];
        
        for(int i=0; i<m; i++){
            dfs(heights,pacific, i, 0, m,n,Integer.MIN_VALUE);
            dfs(heights,atlantic,i,n-1,m,n,Integer.MIN_VALUE);
        }
          for(int i=0; i<n; i++){
            dfs(heights,pacific, 0, i, m,n,Integer.MIN_VALUE);
            dfs(heights,atlantic,m-1,i,m,n,Integer.MIN_VALUE);
        }


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j])
                res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }


    public void dfs(int[][] heights, boolean[][] visited, int i, int j,
    int m, int n, int prevHeight){
        if(i<0 || j<0 || i==m || j==n || visited[i][j] || heights[i][j]<prevHeight)
        return;
        visited[i][j]=true;
        dfs(heights,visited,i+1,j,m,n,heights[i][j]);
         dfs(heights,visited,i,j-1,m,n,heights[i][j]);
          dfs(heights,visited,i-1,j,m,n,heights[i][j]);
           dfs(heights,visited,i,j+1,m,n,heights[i][j]);
    }
}
}
