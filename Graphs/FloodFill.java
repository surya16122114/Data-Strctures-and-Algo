public class FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int ogColor=image[sr][sc];
            if(ogColor==color)
            return image;
            int m=image.length;
            int n=image[0].length;
           
            dfs(image, sr, sc, color,m,n, ogColor);
    
            return image;
            
        }
    
        public void dfs(int[][] image, int sr, int sc, int color, int m, 
        int n, int ogColor){
    
            if(sr<0 || sr>=m || sc<0 || sc>=n || image[sr][sc]!=ogColor)
            return;
    
            image[sr][sc]=color;
    
            dfs(image, sr+1, sc, color, m,n, ogColor);
            dfs(image, sr, sc+1, color, m,n,ogColor);
            dfs(image, sr-1, sc, color, m,n,ogColor);
            dfs(image, sr, sc-1, color, m,n,ogColor);
            
        }
    }
}
