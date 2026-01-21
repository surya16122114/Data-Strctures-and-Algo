public class NumberOfProvinces {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int m=isConnected.length;
         int ans=0;
         boolean[] visited=new boolean[m];
            for(int i=0; i<m; i++){
               if(!visited[i])
               {
                dfs(isConnected,i,visited);
                ans++;
               }
            }
    
            return ans;
        }
    
    
        public void dfs(int[][] isConnected, int start, boolean[] visited){
            visited[start]=true;
    
            for(int i=0; i<isConnected[start].length; i++){
                if(isConnected[start][i]!=0 && !visited[i])
                dfs(isConnected, i, visited);
            }
        }
    }
}
